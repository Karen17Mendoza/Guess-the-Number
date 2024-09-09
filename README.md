# Guess The Number 🎲

## Índice

1. [Descripción](#descripción)
2. [Características](#características)
3. [Estructura del Proyecto](#estructura-del-proyecto)
4. [Instrucciones del juego](#instrucciones-del-juego)

## Descripción

"Guess The Number" es un juego en el que los jugadores intentan adivinar un número objetivo generado aleatoriamente por el sistema. El juego se juega en la consola y permite a un jugador humano competir contra una computadora para adivinar el número en la menor cantidad de intentos posibles.

El proyecto está implementado en Java y utiliza JUnit y Mockito para pruebas unitarias, asegurando la correcta funcionalidad del código.

## Características

- **Juego para un Jugador**: Permite que un jugador humano adivine el número generado por la computadora.
- **Competencia**: El jugador humano compite contra una computadora que también hace sus propias suposiciones.
- **Mensajes de Retroalimentación**: El sistema proporciona pistas sobre si el número objetivo es mayor o menor que la suposición realizada.
- **Historial de Intentos**: Muestra el historial de intentos realizados por ambos jugadores al final del juego.

## Estructura del Proyecto

- `GuessTheNumberGame.java`: Clase principal que maneja el flujo del juego.
- `Player.java`: Clase abstracta que define la estructura básica para los jugadores.
- `HumanPlayer.java`: Implementación de un jugador humano que interactúa con el usuario a través de la consola.
- `ComputerPlayer.java`: Implementación de un jugador de computadora que hace suposiciones aleatorias.
- `HumanPlayerTest.java`: Pruebas unitarias para la clase `HumanPlayer` usando JUnit y Mockito.
- `ComputerPlayerTest.java`: Pruebas unitarias para la clase `ComputerPlayer` usando JUnit y Mockito.

## Instrucciones del juego

- Ingresa tu nombre cuando se te solicite. 📝
- El juego te pedirá que hagas suposiciones sobre el número objetivo. 🎯
- El sistema te dará pistas sobre si el número es mayor o menor que tu suposición. 🔍
- El juego termina cuando uno de los jugadores adivina el número correcto. 🎉



