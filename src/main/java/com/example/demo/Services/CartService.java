package com.example.demo.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import com.example.demo.Entity.Account;
import com.example.demo.Entity.Cart;
import com.example.demo.Entity.Product;
import com.example.demo.Repositories.AccountDAO;
import com.example.demo.Repositories.CartDAO;
import com.example.demo.Repositories.ProductDAO;

import jakarta.servlet.http.HttpSession;
import jakarta.transaction.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class CartService {
	@Autowired
	CartDAO cartDAO;
	@Autowired
	SessionService session;
	@Autowired
	ProductDAO productDao;
	@Autowired
	AccountDAO accountDao;

	public double getTotalCartAmount(Integer accountId) {
		List<Cart> cartItems;
		if (accountId != null) {
			cartItems = cartDAO.findByAccountId(accountId);
		} else {
			cartItems = cartDAO.findByAccountIsNull();
		}

		double total = 0;
		for (Cart cartItem : cartItems) {
			total += cartItem.getTotal();
		}
		return total;
	}

	public int getCount(Integer accountId) {
		List<Cart> cartItems;
		if (accountId != null) {
			cartItems = cartDAO.findByAccountId(accountId);
		} else {
			cartItems = cartDAO.findByAccountIsNull();
		}

		int count = 0;
		for (Cart cartItem : cartItems) {
			count += cartItem.getAmount();
		}
		return count;
	}

	public void addProductToCart(int productId, int quantity, String size, Integer accountId) {
	    if (accountId == null) {
	        System.out.println("Please log in to add products to your cart");
	        return;
	    }
	    Optional<Cart> optionalCartItem = cartDAO.findByProductIdAndSizeAndAccountId(productId, size, accountId);

	    Optional<Product> optionalProduct = productDao.findById(productId);
	    if (optionalProduct.isPresent()) {
	        Product product = optionalProduct.get();
	        Cart newCartItem = optionalCartItem.orElseGet(Cart::new);
	        newCartItem.setProduct(product);
	        newCartItem.setAmount(newCartItem.getAmount() + quantity);
	        newCartItem.setSize(size);

	        Optional<Account> optionalAccount = accountDao.findById(accountId);
	        if (optionalAccount.isPresent()) {
	            newCartItem.setAccount(optionalAccount.get());
	        } else {
	            System.out.println("Account not found");
	            return;
	        }

	        cartDAO.save(newCartItem);
	    } else {
	        System.out.println("Product not found");
	    }
	}


	public void decreaseProductAmount(int productId, String size, Integer accountId) {
		Optional<Cart> optionalCartItem;
		if (accountId != null) {
			optionalCartItem = cartDAO.findByProductIdAndSizeAndAccountId(productId, size, accountId);
		} else {
			optionalCartItem = cartDAO.findByProductIdAndSizeAndAccountIsNull(productId, size);
		}

		optionalCartItem.ifPresent(cartItem -> {
			if (cartItem.getAmount() > 1) {
				cartItem.setAmount(cartItem.getAmount() - 1);
				cartDAO.save(cartItem);
			}
		});
	}

	public void increaseProductAmount(int productId, String size, Integer accountId) {
		Optional<Cart> optionalCartItem;
		if (accountId != null) {
			optionalCartItem = cartDAO.findByProductIdAndSizeAndAccountId(productId, size, accountId);
		} else {
			optionalCartItem = cartDAO.findByProductIdAndSizeAndAccountIsNull(productId, size);
		}

		optionalCartItem.ifPresent(cartItem -> {
			cartItem.setAmount(cartItem.getAmount() + 1);
			cartDAO.save(cartItem);
		});
	}

	public void removeProductFromCart(int productId, String size, Integer accountId) {
		Optional<Cart> optionalCartItem;
		if (accountId != null) {
			optionalCartItem = cartDAO.findByProductIdAndSizeAndAccountId(productId, size, accountId);
		} else {
			optionalCartItem = cartDAO.findByProductIdAndSizeAndAccountIsNull(productId, size);
		}

		optionalCartItem.ifPresent(cartDAO::delete);
	}

	@Transactional
	public void deleteByAccountId(Integer accountId) {
	    cartDAO.deleteByAccountIdOrAccountIdIsNull(accountId);
	}

	public List<Cart> getAllCartItems() {
		Account account = (Account) session.get("acc");
		if (account != null) {
			return cartDAO.findByAccountId(account.getId());
		} else {
			return cartDAO.findByAccountIsNull();
		}
	}
}
