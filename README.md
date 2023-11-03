<h1 align="center">⚔️ The Lord Of The Ring ⚔️</h1>

# Introducción | Introduction

En este readme puedes encontrar la descripción del juego en [Español](#spanish-version) (🇪🇸) o en [Inglés](#english-version) (🇬🇧).<br>

Se trata de un ejercicio planteado para hacerlo de dos formas: <br>
**Modo Consola**, que puedes encontrar en el siguiente repositorio: 👉 _https://github.com/anaruedaguiu/TLOTR_Game_.<br> 
Y **Modo Interfaz Gráfica**, que puedes encontrar aquí.<br>
La lógica es la misma, lo único que cambia entre las dos versiones es el modo de ejecución.

<p align="center">
  ---------------
</p>

In this readme, you can find the game description in [Spanish](#spanish-version) (🇪🇸) or in [English](#english-version) (🇬🇧).<br>

This is an exercise designed to be done in two ways: <br>
**Console Mode**, which you can find in the following repository: 👉 _https://github.com/anaruedaguiu/TLOTR_Game_.<br> 
And **Graphical User Interface (GUI) Mode**, which you can find here.<br>
The logic is the same, the only thing that changes between the two versions is the execution mode.

# Spanish Version

## Tabla de contenidos 
* [Descripción del juego](#descripción-del-juego)
* [Modo Consola](#modo-consola)
* [Modo Interfaz Gráfica](#modo-interfaz-gráfica)

## Descripción del juego

<h3 align="center">· En este apartado se detalla la información de los requerimientos y características del juego 🎲</h3><br>

La aplicación consiste en crear un juego basado en el famoso libro de fantasía de *El Señor De Los Anillos*.<br>
Existirán dos tipos de personajes en el juego, es decir, dos bandos: **Héroes** & **Bestias**. 

En el bando de los héroes se encontrarán tres tipos de personajes: **Elfos**, **Hobbits** y **Humanos** 🧝<br>
Y en el bando de las bestias se podrá distinguir entre: **Orcos** y **Trasgos** 👹

- Objetivo del juego:
  
  Crear dos ejércitos, uno de héroes y otro de bestias, que se enfretarán entre ellos mediante un sistema de turnos hasta que haya un bando vencedor.
  Para ello, cada personaje constará de un **nombre**, una puntuación de **vida** (número entero) y una puntuación de **armadura** (número entero).

- Peculiaridades:

  En cada turno, un personaje podrá atacar a su adversario con las siguientes peculiaridades:

  - Los héroes basarán su ataque en la tirada de dos dados con valores de entre 0 y 100 (ambos incluidos), donde se elegirá el mayor valor de los dos como la potencia ofensiva del ataque en esa tirada.

  - Las bestias basarán su ataque en la tirada de un único dado con valores de entre 0 y 90 (ambos incluidos), por lo que el resultado que salga será la potencia ofensiva de su ataque.

  - Una vez calculadas las potencias ofensivas de los ataques, el daño infligido al adversario se calculará en función de su nivel de armadura.
  De manera que, sólo se producirá un daño al adversario si la potencia ofensiva del ataque es superior al nivel de armadura del defensor.
  En cuyo caso, el valor del daño se calculará como la diferencia entre la potencia del ataque y el nivel de armadura del oponente:<br>
  <p align="center">
  (Potencia ofensiva del ataque - Nivel de armadura = Daño)
  </p>

- Supuestos particulares de cada personaje:
 
    En cada ataque se deberán tener en cuenta los supuestos particulares de cada personaje:

  - Elfos: este tipo de personaje siente un odio epecial por los Orcos, por lo que cuando se enfrenten a bestias de este tipo incrementarán su potencia ofensiva calculada en la tirada de dados en 10 unidades 
   (+10 puntos).

  - Hobbits: debido al miedo que sienten los hobbits por los trasgos, siempre que se enfrenten a ellos, perderán 5 unidades de su potencia ofensiva (-5 puntos).

  - Orcos: los orcos poseen una fuerza desmesurada, por lo que siempre que realicen un ataque disminuirán en un 10% (-10%) el nivel de armadura del contrincante.
  - Sin embargo, el nivel de armadura no se reduce de forma permanente, sólo en el turno actual.
 
- Proceso de batalla entre los ejércitos:

  Una vez descrito el proceso de lucha individual entre personajes, se describirá el proceso de la batalla entre los ejércitos.

  Se seguirá un sistema basado en turnos en el que en cada turno un personaje de un ejército atacará a un único adversario del ejército oponente.
  Para simplificar el sistema de batalla, se enfrentarán siempre los personajes situados en la misma posición de cada ejército.
  Si alguno de los ejércitos dispone de más efectivos que el contrario, los personajes sobrantes no participarán en ese turno de batalla.
  En cada turno se producirán todos los enfrentamientos y se disminuirá la vida de cada personaje siguiendo las instrucciones mencionadas anteriormente.
  En el momento en que un personaje llegue a un nivel de vida igual o inferior a cero se producirá su muerte por lo que se eliminará de su posición y se desplazarán todos sus compañeros en posiciones posteriores para cubrir la baja.
  De esa forma, alguno de los personajes inactivos podrá participar en la batalla en los siguientes turnos.

 ## Modo Consola

 <h3 align="center">· En este apartado se resume lo que se espera de la versión por consola 🛡️</h3><br>

  El proyecto está planteado para elaborarse de dos formas. El primero es el **Modo Consola**, que constará de una ejecución más sencilla.
  El programa mostrará por consola el discurrir de la batalla de forma que podamos comprobar que su funcionamiento es correcto.<br>
  En este caso particular, se han incluido algunas preguntas para el usuario/a nada más arrancar el programa como: si quiere empezar una partida, a qué bando quiere pertenecer,
  qué personajes (de los que ya vienen creados) quiere que conforme el bando que ha seleccionado, o si quiere formar el bando contrario eligiendo los personajes o al azar.
  Después de responder esta serie de preguntas, comienza la batalla aplicando la lógica del juego descrita anteriormente hasta que finalmente haya un bando vencedor.<br>
  
  · PARA SABER MÁS:<br> 
    Puedes encontrar el proyecto en el siguiente repositorio: 👉 _https://github.com/anaruedaguiu/TLOTR_Game_

 ## Modo Interfaz Gráfica

 <h3 align="center">· En este apartado se detalla lo que se espera de la versión con interfaz gráfica 🧙</h3><br>

  El segundo planteamiento es el **Modo Interfaz Gráfica**, que presenta una ejecución más elaborada. En esta versión se permitirá de forma interactiva crear los ejércitos de héroes y bestias.
  Una vez creamos los ejércitos se los pondrá a luchar y el resultado se verá a través de una ventana de texto de forma similar a como se hace en la consola.<br>
  Esta versión se ha desarrollado utilizando __*Java FX*__.<br>
  
  A continación, se muestra una explicación más detallada del funcionamiento de la interfaz gráfica incluyendo capturas de pantalla:<br>
  
  -En primer lugar, se rellenan los campos necesarios para crear personajes, tanto héroes como bestias. Si no se rellena algún campo obligatorio, en este caso todos, 
  aparecerá una ventana emergente avisando de que se debe rellenar.<br>
  -Los valores de vida y armadura se pueden seleccionar usando las flechas de los spinners para aumentar o disminuir los valores de uno en uno, o se puede insertar directamente esribiendo un valor.
  En ambos casos existen límites para estos valores, para la vida el rango de valores va de 1 a 300 y para la armadura de 1 a 60.<br> 
  -Una vez que se hayan completado los datos del personaje, se podrá _Añadir_ al ejército, por lo que pasará a estar en el recuadro inferior donde aparece el listado de personajes que conforma el 
  Ejército de Héroes y el Ejército de Bestias.<br>
  -Cuando el usuario/a considere que ambos ejércitos están listos para luchar, podrá hacer clic en el botón _¡Lucha!_ y comenzará a mostrarse el discrurrir de la batalla a través de la ventana de texto
  que aparece debajo, de manera similar a cómo se hizo en el Modo Consola. Durante la batalla, se han inhabilitado algunas funciones (por ejemplo, los botones de _Añadir_ o _Luchar_) hasta que esta termine
  y haya un bando vencedor.<br>
  -Finalmente, cuando la batalla finalice, aparecerá una ventana emergente con un mensaje de cuál ha sido el ejército vencedor. A partir de aquí, se podrá crear otra partida si se desea.

  <h3 align="center">📷 Capturas de pantalla de la Interfaz Gráfica de Java FX</h3>
  <p align="center">(Haz clic en la imagen que desees ver a mayor tamaño)<p>
  <p align="center"> 
    <img src="https://github.com/anaruedaguiu/TLOTR_Game_JavaFX/blob/main/src/main/resources/screenshot_javaFX1.PNG" alt="Main view of the graphical interface" width="250px">
    <img src="https://github.com/anaruedaguiu/TLOTR_Game_JavaFX/blob/main/src/main/resources/screenshot_javaFX2.PNG" alt="View of the pop-up window with the message'Fill in mandatory fields'" width="250px">
    <img src="https://github.com/anaruedaguiu/TLOTR_Game_JavaFX/blob/main/src/main/resources/screenshot_javaFX3.PNG" alt="View of the lists of the Armies of Heroes and Beasts" width="250px">
    <img src="https://github.com/anaruedaguiu/TLOTR_Game_JavaFX/blob/main/src/main/resources/screenshot_javaFX4.PNG" alt="View of the text window where the course of the battle is narrated. Disabled buttons 
    are visible" width="250px">
    <img src="https://github.com/anaruedaguiu/TLOTR_Game_JavaFX/blob/main/src/main/resources/screenshot_javaFX5.PNG" alt="View of the pop-up window with the message of the winning Army in the game"   
    width="250px">
  </p>

  

# English Version

## Table of contents
* [Game description](#game-description)
* [Console Mode](#console-mode)
* [Graphical User Interface Mode](#graphical-user-interface-mode)

## Game description

<h3 align="center">· This section provides detailed information on the game's requirements and features 🎲</h3><br>

The application aims to create a game based on the famous fantasy book *The Lord of the Rings*.<br>
There will be two types of characters in the game, which means two sides: **Heroes** & **Beasts**.

In the Heroes side, you will find three types of characters: **Elves**, **Hobbits**, and **Humans** 🧝<br>
And in the Beasts faction, you can distinguish between: **Orcs** and **Goblins** 👹

- Game Objective:

  Create two armies, one of heroes and the other of beasts, which will face each other in turns until there is a winning faction.
  For this purpose, each character will have a **name**, a **life** score (integer), and an **armor** score (integer).

- Peculiarities:

  In each turn, a character can attack their opponent with the following peculiarities:

  - Heroes will base their attack on the roll of two dice with values between 0 and 100 (both included), where the higher value of the two will be chosen as the offensive power of the attack in that roll.

  - Beasts will base their attack on the roll of a single die with values between 0 and 90 (both included), so the resulting value will be the offensive power of their attack.

  - Once the offensive powers of the attacks are calculated, the damage inflicted on the opponent will be calculated based on their armor level.
    Thus, damage will only occur to the opponent if the offensive power of the attack is higher than the defender's armor level.
    In this case, the damage value will be calculated as the difference between the attack power and the opponent's armor level:<br>
    <p align="center">
      (Offensive power of the attack - Armor level = Damage)
    </p>

- Specific Assumptions for Each Character:

  Each attack should take into account the specific assumptions of each character:

  - Elves: this type of character harbors a special hatred for Orcs, so when facing beasts of this type, they will increase their offensive power calculated in the dice roll by 10 units (+10 points).
  
  - Hobbits: due to the fear Hobbits feel for Goblins, whenever they face them, they will lose 5 units of their offensive power (-5 points).
  
  - Orcs: Orcs possess immense strength, so whenever they make an attack, they will decrease the opponent's armor level by 10% (-10%).
    However, the armor level is not permanently reduced, only in the current turn.

- Battle Process between Armies:

  After describing the individual combat process between characters, we will describe the process of battle between armies.

  A turn-based system will be followed, in which, in each turn, a character from one army will attack a single opponent from the opposing army.
  To simplify the battle system, characters positioned in the same position of each army will always face each other.
  If one of the armies has more troops than the other, the surplus characters will not participate in that turn of battle.
  In each turn, all confrontations will take place, and the life of each character will be reduced following the instructions mentioned earlier.
  When a character's life reaches zero or below, they will die, and they will be removed from their position, with all their comrades behind them moving to cover the vacancy.
  In this way, some of the inactive characters may participate in the battle in the following turns.

## Console Mode

<h3 align="center">· This section summarizes what is expected from the console version 🛡️</h3><br>

The project is designed to be developed in two ways. The first one is the **Console Mode**, which will feature a simpler execution.
The program will display the course of the battle through the console so that we can verify that its operation is correct.<br>
In this particular case, some questions for the user are included right after starting the program, such as whether they want to start a game, 
which side they want to belong to, which characters (from those already created) they want to form the selected side, or if they want to form the opposing side by choosing characters or at random.
After answering this series of questions, the battle begins by applying the game logic described above until there is finally a winning side.<br>

· TO LEARN MORE:<br>
  You can find the project in the following repository: 👉 _https://github.com/anaruedaguiu/TLOTR_Game_

## Graphical User Interface Mode

<h3 align="center">· This section details what is expected from the graphical user interface version 🧙</h3><br>

The second approach is the **Graphical User Interface (GUI) Mode**, which offers a more elaborate execution. In this version, it will be possible to interactively create the armies of heroes and beasts. 
Once we create the armies, they will be set to battle, and the result will be displayed through a text window in a similar way to how it is done in the console.<br>
This version has been developed using __*Java FX*__.<br>

Below is a more detailed explanation of the operation of the graphical interface, including screenshots:<br>

-First, you fill in the necessary fields to create characters, both heroes and beasts. If any mandatory field is left empty, in this case all of them,
a pop-up window will appear, warning that the fields must be filled in.<br>
-The values for life and armor can be selected using the arrows in the spinners to increase or decrease the values one by one, or you can directly enter a value.
In both cases, there are limits for these values, with a range of 1 to 300 for life and 1 to 60 for armor.<br>
-Once the character data has been completed, you can add it to the army, so it will appear in the lower box that lists the characters making up the
Army of Heroes and the Army of Beasts.<br>
-When the user considers that both armies are ready to fight, they can click the fight button, and the course of the battle will begin to be displayed through the text window that appears below,
similar to how it was done in Console Mode. During the battle, some functions have been disabled (e.g., the add or fight buttons) until it ends and there is a winning side.<br>
-Finally, when the battle ends, a pop-up window will appear with a message indicating which army has emerged as the winner. From this point, another game can be created if desired.

<h3 align="center">📷 Screenshots of the Java FX's Graphical Interface</h3>
<p align="center">(Click on the image you want to view in a larger size)<p>
<p align="center"> 
    <img src="https://github.com/anaruedaguiu/TLOTR_Game_JavaFX/blob/main/src/main/resources/screenshot_javaFX1.PNG" alt="Main view of the graphical interface" width="250px">
    <img src="https://github.com/anaruedaguiu/TLOTR_Game_JavaFX/blob/main/src/main/resources/screenshot_javaFX2.PNG" alt="View of the pop-up window with the message'Fill in mandatory fields'" width="250px">
    <img src="https://github.com/anaruedaguiu/TLOTR_Game_JavaFX/blob/main/src/main/resources/screenshot_javaFX3.PNG" alt="View of the lists of the Armies of Heroes and Beasts" width="250px">
    <img src="https://github.com/anaruedaguiu/TLOTR_Game_JavaFX/blob/main/src/main/resources/screenshot_javaFX4.PNG" alt="View of the text window where the course of the battle is narrated. Disabled buttons 
    are visible" width="250px">
    <img src="https://github.com/anaruedaguiu/TLOTR_Game_JavaFX/blob/main/src/main/resources/screenshot_javaFX5.PNG" alt="View of the pop-up window with the message of the winning Army in the game"   
    width="250px">
  </p>
