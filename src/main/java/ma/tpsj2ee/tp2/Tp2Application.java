package ma.tpsj2ee.tp2;

import ma.tpsj2ee.tp2.entities.Product;
import ma.tpsj2ee.tp2.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.List;

@SpringBootApplication
public class Tp2Application implements CommandLineRunner {
    @Autowired
    private ProductRepository productRepository;
    public static void main(String[] args) {

        SpringApplication.run(Tp2Application.class, args);
    }

    @Override
    public void run(String... args) throws Exception {
        //Ajout de produits
       // productRepository.save(new Product(null,"Computer",4300,3));
        //productRepository.save(new Product(null,"Printer",1200,4));
        //productRepository.save(new Product(null,"Phone",3200,32));
        //Afficher les produits
        List<Product> products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());

        });
        Product product=productRepository.findById(Long.valueOf(2)).get();
        System.out.println("**********************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());

        System.out.println("**********************");
        System.out.println("Modify");
        product.setName("Comp2");
        product.setPrice(5400);
        product.setQuantity(5);
        System.out.println("**********************");
        System.out.println(product.getId());
        System.out.println(product.getName());
        System.out.println(product.getQuantity());
        System.out.println("**********************");
        System.out.println("Delete id 1");
        productRepository.deleteById(Long.valueOf(1));
        products = productRepository.findAll();
        products.forEach(p->{
            System.out.println(p.toString());

        });

        System.out.println("**********************");


        System.out.println("Chercher Produit par Nom et Prix");

        List<Product> pr=productRepository.findProductByNameAndPrice("Printer",1200);
        pr.forEach(p->{
            System.out.println(p.toString());

        });
        System.out.println("**********************");
        System.out.println("Chercher Produit Prix Supperieur a 1200");

        List<Product> pr3=productRepository.findByPriceGreaterThan(1200);
        pr3.forEach(p->{
            System.out.println(p.toString());

        });
        System.out.println("**********************");


        System.out.println("Chercher Produit par Nom ");

        List<Product> pr2=productRepository.search("%C%");
        pr2.forEach(p->{
           System.out.println(p.toString());

        });
        System.out.println("**********************");
        System.out.println("Chercher Produit par prix ");

        List<Product> pr4=productRepository.searchByPrice(3000);
        pr4.forEach(p->{
            System.out.println(p.toString());

        });




    }
}
