package homework_menu;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class Main {

    static EntityManagerFactory emf;
    static EntityManager em;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        try {
            // create connection
            emf = Persistence.createEntityManagerFactory("JPAHome1");
            em = emf.createEntityManager();
            try {
                while (true) {
                    System.out.println("1: Создать базовое меню");
                    System.out.println("2: Добавить блюдо в меню");
                    System.out.println("3: Показать блюда по стоимости (от и до)");
                    System.out.println("4: Блюда со скидкой");
                    System.out.println("5: Набор блюд до 1кг");
                    System.out.print("-> ");

                    String st = sc.nextLine();
                    switch (st) {
                        case "1":
                            createMenu();
                            break;
                        case "2":
                            addDishInMenu();
                            break;
                        case "3":
                            atCost();
                            break;
                        case "4":
                            withDiscount();
                            break;
                        case "5":
                            setOfDishes();
                            break;
                        default:
                            return;
                    }
                }
            } finally {
                em.close();
                emf.close();
            }
        } catch(Exception ex){
                ex.printStackTrace();
                return;
        }
    }


    public static void createMenu() throws SQLException {
        em.getTransaction().begin();
        try {
            Menu menu1 = new Menu("borch",50,400,true);
            Menu menu2 = new Menu("pyre",20,300,false);
            Menu menu3 = new Menu("kotleta",25,150,false);
            Menu menu4 = new Menu("kompot",10,250,false);
            em.persist(menu1);
            em.persist(menu2);
            em.persist(menu3);
            em.persist(menu4);
            em.getTransaction().commit();
            System.out.println("Базовое меню создано");
        } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("Базовое НЕ меню создано");
        }
    }

    public static void addDishInMenu() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите имя блюда");
        String dishName = scan.nextLine();
        System.out.println("Введите цену блюда");
        double price = scan.nextDouble();
        System.out.println("Введите вес блюда");
        double weight = scan.nextDouble();
        System.out.println("Введите есть ли скидка на блюдо");
        boolean discount = scan.hasNextBoolean();

        em.getTransaction().begin();
        try {
            Menu newMenu = new Menu(dishName,price,weight,discount);
            em.persist(newMenu);
            em.getTransaction().commit();
            System.out.println("Блюдо в меню добавлено");
        } catch (Exception e){
            em.getTransaction().rollback();
            System.out.println("Блюдо в меню НЕ добавлено :(");
        }

    }

    public static void atCost() throws SQLException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Введите от какой стоимости");
        double from = scan.nextDouble();
        System.out.println("Введите до какой стоимости");
        double to = scan.nextDouble();

        em.getTransaction().begin();
        try{
            Query query = em.createQuery("FROM Menu m" +
                            " WHERE m.price >= :fromPrice AND m.price <= :toPrice", Menu.class);
            query.setParameter("fromPrice", from);
            query.setParameter("toPrice", to);

            List<Menu> menuResult = query.getResultList();

            for (Menu dish: menuResult){
                System.out.println(dish);
            }
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        }
    }

    public static void withDiscount() throws SQLException {
        em.getTransaction().begin();
        try{
            Query query = em.createQuery("FROM Menu m"+
                    " WHERE m.discount = :discount", Menu.class);
            query.setParameter("discount", true);

            List<Menu> menuResult = query.getResultList();

            for (Menu dish: menuResult){
                System.out.println(dish);
            }
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        }
    }

    public static void setOfDishes() throws SQLException {
        em.getTransaction().begin();
        try{
            Query query = em.createQuery("FROM Menu m" +
                    " WHERE m.weight != null", Menu.class);
            List<Menu> menuResult = query.getResultList();
            double kg = 0;
            for (Menu dish: menuResult){
                kg = kg+ dish.getWeight();
                if (kg <= 1000){
                    System.out.println(dish);
                } else {
                    break;
                }

            }
            em.getTransaction().commit();
        } catch (Exception e){
            em.getTransaction().rollback();
        }
    }
}
