package org.example.stepDef;

import org.example.Page.Po4_ShoppingCart;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.testng.asserts.SoftAssert;

public class DO9_ShoppingCartStepDef {
    Po4_ShoppingCart cart=new Po4_ShoppingCart(Hooks.driver);
    @When("User click add cart button for two products")
    public void add_product_ToCart() throws InterruptedException {
        cart.AddFirstProduct();
        cart.AddSecondProduct();
        Thread.sleep(10000);
    }
    @Then("System add products to cart  and increase rows of Shopping cart table")
    public void Validate_Add_Product_To_Cart_Successfully(){
        SoftAssert soft= new SoftAssert();
        soft.assertTrue(cart.GetCartListQuantity()>0);
        soft.assertTrue(cart.NoOFProducts()>0);
        soft.assertAll();
    }

}
