package pl.coderslab;

public class GenerateDao {
    public static void main(String[] args) {
        generateDao("Person");
    }
    public static void generateDao(String daoType) {
        String daoLowercase = daoType.toLowerCase();
        String daoUppercase = daoLowercase.substring(0, 1).toUpperCase() + daoLowercase.substring(1);
        System.out.println("@Repository\n" +
                "@Transactional\n" +
                "public class "+daoUppercase+"Dao {\n" +
                "\n" +
                "    @PersistenceContext\n" +
                "    EntityManager entityManager;\n" +
                "\n" +
                "    public void save"+daoUppercase+"("+daoUppercase+" "+daoLowercase+") {\n" +
                "        entityManager.persist("+daoLowercase+");\n" +
                "    }\n" +
                "\n" +
                "    public "+daoUppercase+" findById(long id) {\n" +
                "        return entityManager.find("+daoUppercase+".class, id);\n" +
                "    }\n" +
                "\n" +
                "    public void update("+daoUppercase+" "+daoLowercase+") {\n" +
                "        entityManager.merge("+daoLowercase+");\n" +
                "    }\n" +
                "\n" +
                "    public void delete("+daoUppercase+" "+daoLowercase+") {\n" +
                "        entityManager.remove(entityManager.contains("+daoLowercase+") ?\n" +
                "                "+daoLowercase+" : entityManager.merge("+daoLowercase+"));\n" +
                "    }\n" +
                "}");
    }
}
