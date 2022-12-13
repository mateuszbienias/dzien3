package com.coderslab.dzien3;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

@WebServlet("/session4")
public class Session4 extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        HttpSession session = req.getSession();
        String name = req.getParameter("name");
        String quantity = req.getParameter("quantity");
        String price = req.getParameter("price");

        if (session.isNew() && Objects.isNull(session.getAttribute("cartItems"))) {
            List<CartItem> cartItems = CartItem.cartItems;
            session.setAttribute("cartItems", cartItems);
        }
        if (Objects.nonNull(name) && Objects.nonNull(price) && Objects.nonNull(quantity)) {
            CartItem cartItem = new CartItem(name, Integer.parseInt(quantity), Double.parseDouble(price));
            List<CartItem> cartSessionItems = (List<CartItem>) session.getAttribute("cartItems");
            cartSessionItems.add(cartItem);
            session.setAttribute("cartItems", cartSessionItems);
        }
        resp.setCharacterEncoding("UTF-8");
        resp.getWriter().append("<html><head><meta charset=\"utf-8\"></head><body><p>");
        double sumCarts = 0;

        for (CartItem cartItem: (List<CartItem>) session.getAttribute("cartItems")
             ) {
            double sumItem = cartItem.getQuantity()*cartItem.getPrice();
            String cartItemToPrint = "Name: " + cartItem.getName()+ " - "
                    + cartItem.getQuantity() + " x "
                    + cartItem.getPrice() + " = "
                    + sumItem + "zł</p>";
            sumCarts+=sumItem;

            resp.getWriter().append(cartItemToPrint);
        }
        resp.getWriter().append("              " + "SUMA: " + sumCarts + "zł");
        resp.getWriter().append("</body></html>");
    }
}
