package database;

import java.util.Properties;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.sql.DataSource;
import org.hibernate.jpa.HibernatePersistenceProvider;
import org.postgresql.ds.PGSimpleDataSource;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

public class DbConfigurator {
  // The method must return a DataSource object
  // In method, it actually returns dataSource which is a PGSimpleDataSource object
  // data
  public DataSource getDataSource() {
    // PGSimpleDataSource is a subclass of DataSource
    final PGSimpleDataSource dataSource = new PGSimpleDataSource();
//        dataSource.setDatabaseName("OrmDemo");
    dataSource.setUser("qiwei");
    dataSource.setPassword("");
    dataSource.setUrl("jdbc:postgresql://localhost:5432/registration");
    return dataSource;
  }

  public Properties getProperties() {
    final Properties properties = new Properties();
    properties.put( "hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect" );
    properties.put( "hibernate.connection.driver_class", "org.postgresql.Driver" );
//        properties.put("hibernate.show_sql", "true");
    return properties;
  }

  public EntityManagerFactory entityManagerFactory(DataSource dataSource, Properties hibernateProperties ){
    final LocalContainerEntityManagerFactoryBean em = new LocalContainerEntityManagerFactoryBean();
    em.setDataSource(dataSource);
    em.setPackagesToScan( "database" );
    em.setJpaVendorAdapter( new HibernateJpaVendorAdapter() );
    em.setJpaProperties( hibernateProperties );
    em.setPersistenceUnitName( "demo-unit" );
    em.setPersistenceProviderClass(HibernatePersistenceProvider.class);
    em.afterPropertiesSet();
    return em.getObject();
  }

  public EntityManager getEntityManager() {
    DataSource dataSource = this.getDataSource();
    Properties properties = this.getProperties();
    EntityManagerFactory entityManagerFactory = this.entityManagerFactory(dataSource, properties);
    EntityManager em = entityManagerFactory.createEntityManager();

    return em;
  }

}
