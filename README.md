
Proje detayları 

Veteriner MVC uygulaması olucak olup login,validation gibi kısımları içermektedir
------------------------------------------

Model Packages : 
- Hayvan: Hayvana ait olan bilgilerin oldugu modeldir.
- HayvanSahibi: Hayvan sahibine ait bilgilerin oldugu modeldir
- HayvanHayvanSahibi: Hayvan ile sahibi arasındaki ilişkisel modeldir

------------------------------------------

Repository Packages :
-	HayvanHayvanSahibiRepository:Hayvan ve Hayvan sahiplerinin arasındaki ilişkiyi sorgular.
-	HayvanRepository:Hayvanların database ilişkileri sorgular.
-	HayvanSahibiRepository: Hayvan sahiplerin database ile ilişkilerini  sağlar

------------------------------------------

Config Packages :
- StringResponse: Geriye bir String döndürülmek için yapılmıştır.

------------------------------------------

Controller Packages : Post,Get,Put temel controller yapıısını içerir
- AdminController: Adminler için silme yükleme gibi birçok userda bulunmayan işi yapmasının controlleridir.
- UserController : User Controller ise kendi alanında bulunan işlemleri yapabilir.

-------------------------------------------
Service Packages : 
- HayvanService : Hayvanlara ait listeleme,update,delete gibi CRUD işlemleri içeren Servistir.
- HayvanSahibiService : Hayvan sahiplerine ait CRUD işlemlerini içerir.
- HayvanHayvanSahibiService : Hayvan ve sahipleri arasındaki ilişkiyi sorgulayan ve yazdıran servistir.

--------------------------------------------

ServiceIMP Packages: Service paketi içinde bulunur ve servisdeki fonksiyonları içerir.
- HayvanHayvanSahibiServiceImp: Hayvan ve sahipleri arasındaki fonksyionları içermektedir.
- HayvanSahibiServiceImp: Hayvan Sahibi servisine ait fonksiyonları içerir.
- HayvanServiceImp: Hayvan servisine ait fonksiyonları içerir.

----------------------------------------------

Projemde kullanılan kütüphaneler:

-	**Spring Boot DevTools**  :  Provides fast application restarts, LiveReload, and configurations for enhanced development experience.

-	**Lombok :**(get,set,tostring) Java annotaton library which helps to reduce boilerplate code.

-	**Spring Web WEB Build web,** including RESTful, applications using Spring MVC. Uses Apache Tomcat as the default embedded container.

-	**Thymeleaf** TEMPLATE ENGINES A modern server-side Java template engine for both web and standalone environments. Allows HTML to be correctly displayed in browsers and as static prototypes.

-	**Spring Security** SECURITY Highly customizable authentication and access-control framework for Spring applications.

-	**Spring Data JPA** SQL Persist data in SQL stores with Java Persistence API using Spring Data and Hibernate.

-	**Spring Native [Experimental] ** Incubating support for compiling Spring applications to native executables using the GraalVM native-image compiler.

-	**MySQL Driver** SQL MySQL JDBC and R2DBC driver.

-	**Java Mail Sende**r I/O Send email using Java Mail and Spring Framework's JavaMailSender.

-	**Validation** I/O Bean Validation with Hibernate validator.
