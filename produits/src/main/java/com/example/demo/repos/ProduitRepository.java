package com.example.demo.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.example.demo.entities.Categorie;
import com.example.demo.entities.Produit;

import antlr.collections.List;



public interface ProduitRepository extends JpaRepository<Produit, Long> {
java.util.List<Produit> findByNomProduit(String nom);
java.util.List<Produit> findByNomProduitContains(String nom);

//@Query("select p from Produit p where p.nomProduit like %?1 and p.prixProduit > ?2")
//List<Produit> findByNomPrix (String nom, Double prix);


@Query("select p from Produit p where p.nomProduit like %:nom and p.prixProduit > :prix")
java.util.List<Produit> findByNomPrix (@Param("nom") String nom,@Param("prix") Double prix);

@Query("select p from Produit p where p.categorie = ?1")
List findByCategorie (Categorie categorie);


java.util.List<Produit> findByCategorieIdCat(Long id);

java.util.List<Produit> findByOrderByNomProduitAsc();
@Query("select p from Produit p order by p.nomProduit ASC, p.prixProduit DESC")
java.util.List<Produit> trierProduitsNomsPrix ();
}
