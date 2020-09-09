class Argument {
  float xArgument, yArgument;
  int coutArgument;
  PImage argument;
  int i;

  int [] posX = {226+140, 214+140, 212+140, 126+140 };
  int [] posY = {480, 542, 602, 526 };
  int [] posX1 = {0, 506+140, 360+140, 359+140 };
  int [] posY1 = {0, 255, 150, 132 };
  int [] posX2 = {0, 0, 596+140, 595+140 };
  int [] posY2 = {0, 0, 320, 269 };
  int [] posX3 = {0, 0, 0, 595+140 };
  int [] posY3 = {0, 0, 0, 528 };

  int[] postionX;
  int[] postionY;


  Argument(int ct) {
    argument = loadImage(argumentFile[0]);
    argument.resize(int(argument.width/2.2), int (argument.height/2.2));

    coutArgument = ct;

    switch(coutArgument) {
    case 0:
      postionX = posX;
      postionY = posY;
      break;
    case 1: 
      postionX = posX1;
      postionY = posY1;
      break;
    case 2: 
      postionX = posX2;
      postionY = posY2;
      break;
    case 3: 
      postionX = posX3;
      postionY = posY3;
      break;
    }
  }

  void update(int currentCout) {

    xArgument = postionX[currentCout];
    yArgument = postionY[currentCout];

    println(currentCout);


    if (ii%4 >= coutArgument) {
      imageMode(CENTER);
      image(argument, xArgument, yArgument);
      fill(255);
      textSize(32);
      text( coutArgument + 1, xArgument - 16, yArgument - 60);
    }
  }

  void calc() {

    if (calculate) {
      if (coutArgument == 0 && ii%4 >= coutArgument) {
        switch(i%4) {
        case 0:
          zoneTotal += 5;
          break;
        case 1:
          effetTotal += 1;
          break;
        case 2:
          tempsTotal += 1;
          break;
        case 3:
          porteeTotal += 10;
          break;
        }
      }
      if (coutArgument == 1 && ii%4 >= coutArgument) {
        switch(i%4) {
        case 0:
          zoneTotal += 5;
          break;
        case 1:
          effetTotal += 1;
          break;
        case 2:
          tempsTotal += 1;
          break;
        case 3:
          porteeTotal += 10;
          break;
        }
      }
      if (coutArgument == 2 && ii%4 >= coutArgument) {
        if ( coutTotal == 4) {
          switch(i%4) {
          case 0:
            zoneTotal += 10;
            break;
          case 1:
            effetTotal += 2;
            break;
          case 2:
            tempsTotal += 2;
            break;
          case 3:
            porteeTotal += 20;
            break;
          }
        } else {
          switch(i%4) {
          case 0:
            zoneTotal += 5;
            break;
          case 1:
            effetTotal += 1;
            break;
          case 2:
            tempsTotal += 1;
            break;
          case 3:
            porteeTotal += 10;
            break;
          }
        }
      }

      if (coutArgument == 3 && ii%4 >= coutArgument) {
        switch(i%4) {
        case 0:
          zoneTotal += 20;
          break;
        case 1:
          effetTotal += 4;
          break;
        case 2:
          tempsTotal += 4;
          break;
        case 3:
          porteeTotal += 40;
          break;
        }
      }
    }
  }

  void mouse() {
    calc();
    if (abs (mouseX - xArgument) < argument.width/2 && abs (mouseY- yArgument) < argument.height/2) {
      i++;
      argument = loadImage(argumentFile[i%4]);
      argument.resize(int(argument.width/2.2), int (argument.height/2.2));
    }
  }
}
