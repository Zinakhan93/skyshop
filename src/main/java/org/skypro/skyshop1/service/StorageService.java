package org.skypro.skyshop1.service;

import org.skypro.skyshop1.model.article.Article;
import org.skypro.skyshop1.model.product.DiscountedProduct;
import org.skypro.skyshop1.model.product.FixPriceProduct;
import org.skypro.skyshop1.model.product.Product;
import org.skypro.skyshop1.model.product.SimpleProduct;
import org.skypro.skyshop1.model.search.Searchable;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class StorageService {
    private final Map<UUID, Product> products = new HashMap<>();
    private final Map<UUID, Article> articles = new HashMap<>();

    public StorageService() {
        initData();
    }

    ;

    private void initData() {
        addProduct(new SimpleProduct(UUID.randomUUID(), "Яблоко", 300));
        addProduct(new FixPriceProduct(UUID.randomUUID(), "Молоко"));
        addProduct(new DiscountedProduct(UUID.randomUUID(), "Хлеб", 150, 10));
        addProduct(new SimpleProduct(UUID.randomUUID(), "Кефир", 80));
        addArticle(new Article(UUID.randomUUID(), "Яблоко", "Яблоко содержит высокое содержание железа"));
        addArticle(new Article(UUID.randomUUID(), "Молоко","Молоко содержит высокое содержание кальция"));
        addArticle(new Article(UUID.randomUUID(),"Кефир", "Кефир полезен для очищения желудка"));

    }

    private void addProduct(Product product) {
        products.put(product.getId(), product);
    }

    private void addArticle(Article article) {
        articles.put(article.getId(), article);
    }

    //Методы получения всех товаров и статей:
    public Collection<Product> getAllProducts() {
        return products.values();
    }
    public Optional<Product> getProductById(UUID id) {
        return Optional.ofNullable(products.get(id));
    }



    public Collection<Article> getAllArticles() {
        return articles.values();
    }
    // Метод получения всех Searchable (для поиска)
    public Collection<Searchable> getAllSearchables() {
        List<Searchable> searchableItems = new ArrayList<>();
        searchableItems.addAll(products.values());
        searchableItems.addAll(articles.values());
        return searchableItems;
    }

}

