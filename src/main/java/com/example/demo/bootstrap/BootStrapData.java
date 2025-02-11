package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.*;

/**
 *
 *
 *
 *
 */
@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

    private final OutsourcedPartRepository outsourcedPartRepository;

    public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository=outsourcedPartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

       /*
        OutsourcedPart o= new OutsourcedPart();
        o.setCompanyName("Western Governors University");
        o.setName("out test");
        o.setInv(5);
        o.setPrice(20.0);
        o.setId(100L);
        outsourcedPartRepository.save(o);
        OutsourcedPart thePart=null;
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            if(part.getName().equals("out test"))thePart=part;
        }

        System.out.println(thePart.getCompanyName());
        */
        List<OutsourcedPart> outsourcedParts=(List<OutsourcedPart>) outsourcedPartRepository.findAll();
        for(OutsourcedPart part:outsourcedParts){
            System.out.println(part.getName()+" "+part.getCompanyName());
        }

        /*
        Product bicycle= new Product("bicycle",100.0,15);
        Product unicycle= new Product("unicycle",100.0,15);
        productRepository.save(bicycle);
        productRepository.save(unicycle);
        */

        Set<Product> sampleProducts = new HashSet<Product>();
        Set<Part> sampleParts = new HashSet<>();

        Product Mac = new Product(1, "Apple MacBook Air", 700.00, 8);
        Product ThinkPad = new Product(2, "Lenovo Thinkpad", 400.00, 5);
        Product Chromebook = new Product(3, "Chromebook", 300.00, 4);
        Product iPhone = new Product(4, "iPhone 16", 1000.00, 7);
        Product Galaxy = new Product(5, "Samsung Galaxy", 1100.00, 6);

        sampleProducts.add(Mac);
        sampleProducts.add(ThinkPad);
        sampleProducts.add(Chromebook);
        sampleProducts.add(iPhone);
        sampleProducts.add(Galaxy);

        System.out.println("Set: " + sampleProducts);

        InhousePart battery = new InhousePart();
        battery.setId(1);
        battery.setName("Battery");
        battery.setPrice(50.00);
        battery.setInv(25);
        battery.setMax_inv(100);
        battery.setMin_inv(1);

        InhousePart screen = new InhousePart();
        screen.setId(2);
        screen.setName("Screen");
        screen.setPrice(60.00);
        screen.setInv(25);
        screen.setMax_inv(100);
        screen.setMin_inv(1);

        InhousePart charger = new InhousePart();
        charger.setId(3);
        charger.setName("Charger");
        charger.setPrice(14.99);
        charger.setInv(25);
        charger.setMax_inv(100);
        charger.setMin_inv(1);

        InhousePart keys = new InhousePart();
        keys.setId(4);
        keys.setName("Keys");
        keys.setPrice(4.99);
        keys.setInv(25);
        keys.setMax_inv(100);
        keys.setMin_inv(1);

        InhousePart mouse = new InhousePart();
        mouse.setId(5);
        mouse.setName("Mouse");
        mouse.setPrice(20.00);
        mouse.setInv(25);
        mouse.setMax_inv(100);
        mouse.setMin_inv(1);

        sampleParts.add(battery);
        sampleParts.add(screen);
        sampleParts.add(charger);
        sampleParts.add(keys);
        sampleParts.add(mouse);

        if (partRepository.count() == 0 && productRepository.count() == 0) {
            for (Product product : sampleProducts) {
                productRepository.save(product);
            }
            for (Part part : sampleParts) {
                partRepository.save(part);
            }
            /*
            productRepository.save(Mac);
            productRepository.save(ThinkPad);
            productRepository.save(ChromeBook);
            productRepository.save(iPhone);
            productRepository.save(Galaxy);

            partRepository.save(battery);
            partRepository.save(screen);
            partRepository.save(charger);
            partRepository.save(keys);
            partRepository.save(mouse);
            */
        }

        System.out.println("Started in Bootstrap");
        System.out.println("Number of Products: "+productRepository.count());
        System.out.println(productRepository.findAll());
        System.out.println("Number of Parts: "+partRepository.count());
        System.out.println(partRepository.findAll());

    }
}
