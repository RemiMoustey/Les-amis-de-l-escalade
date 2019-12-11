# Les Amis de l'escalade : déployer l'application

Après avoir installé Java, vous pouvez déployer l'applicaiton en ligne de commande, à l'aide d'un serveur. Nous prendrons ici Apache Tomcat, qui est déjà intégré au projet.

Téléchargez tout d'abord le fichier .zip contenant l'application disponible ici : https://github.com/RemiMoustey/Les-amis-de-l-escalade. Puis, décompressez-le où vous le souhaitez sur votre disque local.

**1. Connexion à la base de données.**

Créez un dossier nommé _resources_ dans les dossiers _escalade-webapp/src/main_ et _escalade-consumer/src/main_. À l'intérieur de ces dossiers, créez un package (ou une suite de dossiers) de sorte que les chemin soient, à partir de chaque dossier _resources_ respectif : _resources/org/projet6/escalade/webapp_ et _resources/org/projet6/escalade/consumer_.

Puis, dans le dossier  _consumer_, créez un fichier _consumerContext.xml_ et dans le dossier _webapp_, un fichier _applicationContext.xml_.

Ouvrez ces deux fichiers à l'aide d'un éditeur de texte et remplissez-les comme suit :

    <?xml version="1.0" encoding="UTF-8"?>
    <beans xmlns:xsi="http://www.w3.org/2001/XMLSchema-instance"
           xmlns="http://www.springframework.org/schema/beans" xmlns:context="http://www.springframework.org/schema/context"
           xsi:schemaLocation="http://www.springframework.org/schema/beans
            http://www.springframework.org/schema/beans/spring-beans.xsd
            http://www.springframework.org/schema/beans http://www.springframework.org/schema/beans/spring-beans.xsd http://www.springframework.org/schema/context http://www.springframework.org/schema/context/spring-context.xsd">
    
        <context:annotation-config/>
        <context:component-scan base-package="org.projet6.escalade"/>
    
        <!-- ===== DAO ===== -->
        <bean id="siteDao" class="org.projet6.escalade.consumer.impl.dao.SiteDaoImpl">
            <property name="dataSource" ref="dataSource" />
        </bean>
    
        <bean id="memberDao" class="org.projet6.escalade.consumer.impl.dao.MemberDaoImpl">
            <property name="dataSource" ref="dataSource" />
        </bean>
    
        <bean id="commentDao" class="org.projet6.escalade.consumer.impl.dao.CommentDaoImpl">
            <property name="dataSource" ref="dataSource" />
        </bean>
    
        <bean id="topoDao" class="org.projet6.escalade.consumer.impl.dao.TopoDaoImpl">
            <property name="dataSource" ref="dataSource" />
        </bean>
    
        <bean id="awaitingTopoDao" class="org.projet6.escalade.consumer.impl.dao.AwaitingTopoDaoImpl">
            <property name="dataSource" ref="dataSource" />
        </bean>
    
        <bean id="dataSource" class="org.apache.commons.dbcp2.BasicDataSource">
            <property name="driverClassName" value="com.mysql.jdbc.Driver" />
            <property name="url" value="jdbc:mysql:[url vers la base de données]" />
            <property name="username" value="[username de connexion à la base de données]" />
            <property name="password" value="[mot de passe de connexion à la base de données]" />
            <property name="initialSize" value="2" />
        </bean>
    
        <bean id="jdbcTemplate" class="org.springframework.jdbc.core.JdbcTemplate">
            <property name="dataSource" ref="dataSource" />
        </bean>
    </beans>
    
Dans la partie du bean "dataSource", remplacez les données entre crochets par les informations de connexion à votre système de gestion de base de données MySQL.

Après avoir créé une base de données, entrez toutes les requêtes présentes dans les fichiers _create_tables.sql_ et _data.sql_ **dans cet ordre**. Ces requêtes rempliront votre base de données avec des tables et un jeu de données de démonstration.

**2. Lancement du site web en local.**

**Pour déployer l'application, Maven doit être installé. Si ce n'est pas le cas, rendez-vous sur ce tutoriel : https://openclassrooms.com/fr/courses/4503526-organisez-et-packagez-une-application-java-avec-apache-maven/4608805-configurez-votre-environnement-de-developpement**.

Ouvrez ensuite l'invite de commandes et rendez-vous, à l'aide de la commande "cd [chemin vers le répertoire]" dans le dossier racine de l'application. Puis, exécutez la commande suivante :
    
    mvn clean install tomcat7:run
    
À la fin de l'exécution de la commande, vous devriez voir un message semblable à celui-ci :
    
    dÚc. 11, 2019 8:21:40 AM org.apache.catalina.core.StandardEngine startInternal
    INFOS: Starting Servlet Engine: Apache Tomcat/7.0.47
    dÚc. 11, 2019 8:21:41 AM org.apache.coyote.AbstractProtocol start
    INFOS: Starting ProtocolHandler ["http-bio-8080"]
    
La dernière ligne vous permet de découvrir le port sur lequel le site web est déployé (dans cet exemple, il s'agit de 8080).

Rendez-vous alors sur votre navigateur, puis tapez dans la barre d'adresse : _localhost:[le port]/index_ (ici _localhost:8080/index_).

Vous devriez arriver sur la page d'accueil des Amis de l'escalade !