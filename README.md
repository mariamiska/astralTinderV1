# ASTRAL TINDER - Spring Boot App 

# :: Team 9 - C7 - EGG Tech - Full Stack - 2022 ::  Proyecto Final Grupal
<img src=https://user-images.githubusercontent.com/102770961/179436417-f4a82e85-a4fe-4231-91b2-dd24f0723a00.png width="700">

Astral Tinder es una app de citas desarrollada con Spring Boot implementando MVC como patrón de arquitectura.
Usamos el API de persistencia de Java para moldear capa de acceso a datos. Aprovechamos el soporte que JPA proporciona para la ejecución de consultas SQL, así logramos ensamblar una base de datos relacional para vincular los datos de 4 entidades User, Photo, AstralPlane y Vote, necesarias para llevar a cabo la lógica del negocio validada y llevada a cabo en nuestra capa de servicios.

El front esta desarrollado en lenguaje de marcado HTML e implementamos CSS nativo para definir y crear todos los estilos que hacen a la estética de la aplicación.
Además aplicamos la biblioteca de JAVA Thymeleaf para lograr que nuestros templates sean dinámicos. 

<img src=https://user-images.githubusercontent.com/102770961/179436193-43e9b36f-842d-41cb-adf0-52e933d5bf7b.png width="700">

Al igual que otras aplicaciones de citas, nuestro proyecto requiere del usuario un perfil, fotos y datos personales.  Pero también solicita su fecha, hora y lugar de nacimiento para crear una carta de nacimiento, o como nosotros le llamamos "Perfil Astral".
Los usuarios reciben coincidencias con otros respecto a su compatibilidad astral general puntuada por nuestra app, pudiendo mandar "me gusta" o "siguiente" entre usuarios mostrados de manera aleatoria("ruleta"). Si ambos se gustan, se notifica y se desbloquea la posibilidad de acceder a la información de contacto para comunicarse entre si. Y lo más importante, esta aplicación hace que las cartas natales de los usuarios coincidentes ("Matches") estén disponibles entre sí para posteriores consultas.

<img src=https://user-images.githubusercontent.com/102770961/179436446-d5a5ed65-b682-47a0-8c32-54b7c7f3b85c.png width="700">

