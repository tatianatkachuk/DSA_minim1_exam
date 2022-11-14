# DSA_minim1_exam
Examen 10 de noviembre de 2022

Enunciado:
La EETAC está interesada en construir un juego virtual que permita promocionar la escuela. Por este motivo, propone a sus alumnos de DSA la construcción de una prueba piloto del motor del juego con las siguientes
operaciones:
- Creación de un juego. Para la creación de un juego se debe indicar un identificador, una descripción y un número de niveles (nivel1, nivel2, …nivel3).
- Inicio de una partida de un juego por parte de un usuario. Se debe indicar el identificador del juego y el identificador del usuario. El resultado de la operación es que el usuario entra en el primer nivel con 50 puntos iniciales. En caso que el usuario o juego no existan, se deberá indicar el error. Un jugador SÓLO puede estar en una partida al mismo tiempo. En caso que el jugador ya tenga una partida activa, se deberá indicar el error.
- Consulta del nivel actual. Dado un identificador de un usuario que está en una partida en curso, se deberá indicar el nivel actual y la partida. En caso que el usuario no exista o no tenga una partida en curso, se deberá indicar el error.
- Consulta de la puntuación actual. Dado un identificador de usuario se indica la puntuación actual de la partida en curso. En caso que el usuario no exista o no esté en una partida, se deberá indicar el error.
- Pasar de nivel. Se deberá indicar el identificador de usuario, los puntos conseguidos con el paso de nivel y la fecha en la que se produce el cambio de nivel. El resultado de la operación consiste en un cambio del nivel que será el siguiente respecto al que estaba y se mantendrá el acumulado de puntos de esa partida, de ese jugadorl. En caso que el usuario esté en el último nivel, se incrementará la puntuación acumulada en 100 puntos y la partida finalizará. En caso que el usuario no exista o no esté en una partida en curso, se deberá indicar el error.
- Finalizar partida. Se indica que un determinado usuario ha finalizado la partida actual. En caso que el usuario no exista o no esté en una partida en curso de deberá indicar el error.
- Consulta de usuarios que han participado en un juego ordenado por puntuación (descendente). Se indicará un juego y se proporcionará la información. En caso que no exista el juego se deberá indicar el error.
- Consulta de las partidas en las que ha participado un usuario. En caso que el usuario no exista se deberá indicar un error.
- Consulta de la actividad de un usuario sobre un juego. Se proporciona un listado de información asociada a la actividad del usuario en el juego. Ejemplo: actividad(“juan”, “the game”): -> [ {level: 1, points: 5, date: dd-mm-aaaa}, {level:2, points:15, date: dd-mm-aaaa}, {level3: points: 20, date: dd-mm-aaaa}]
 
PARTE I: 
1.-Identificar las entidades de información y sus propiedades. Podéis hacer una propuesta de atributos básica.
2.- Especificación del componente que implementará las operaciones descritas anteriormente: interfaz Java
3.- Implementación de una Fachada (patrón de diseño) que implemente el interfaz definido previamente.
2.1 Elección de las estructuras de datos
2.3 La fachada deberá implementarse como un Singleton. (Opcional)
2.4 Todos los métodos deberán tener una TRAZA (a nivel de INFO) de LOG4J que muestre el valor de los parámetros al inicio de los métodos y al final. También debe contemplarse trazas de otros niveles (ERROR o FATAL)
4.- Implementación de un test (JUNIT) sobre el componente desarrollado. Se debe implementar cuatro operaciones de test anteriormente descritas.

PARTE II:  
1.- Definir (servicio, operaciones, rutas, métodos HTTP, peticiones, respuestas, códigos de respuesta) e implementar un servicio REST que permita realizar las operaciones especificadas en la primera parte del ejercicio. Se recomienda que todas las operaciones deben retornar “objetos de transferencia” y evitar ciclos/relaciones. Si los objetos de negocio son complejos se complica la serialización/deserialización. El servicio debe utilizar el componente construido en el punto anterior.