import processing.core.*; 
import processing.data.*; 
import processing.event.*; 
import processing.opengl.*; 

import java.util.HashMap; 
import java.util.ArrayList; 
import java.io.File; 
import java.io.BufferedReader; 
import java.io.PrintWriter; 
import java.io.InputStream; 
import java.io.OutputStream; 
import java.io.IOException; 

public class spellcalculator extends PApplet {

PImage cout, couleur, sacrifice, light;
float xCout, xCouleur, xSacrifice;
float yCout, yCouleur, ySacrifice;
int ii, iii;


int coutTotal, porteeTotal, effetTotal, tempsTotal, zoneTotal;

Argument arg1, arg2, arg3, arg4; 

String[] coutFile = { "cout1.png", "cout2.png", "cout4.png", "cout16.png"};
String[] couleurFile = { "rouge.png", "vert.png", "bleu.png", "blanc.png", "jaune.png", "pure.png", "multi.png"};
String[] argumentFile  = { "zone.png", "effet.png", "temps.png", "portée.png"};

boolean calculate, HideHUD;
float colorized = 255;


public void setup() {
   
  cout = loadImage(coutFile[0]);
  cout.resize(cout.width/2, cout.height/2);
  couleur = loadImage(couleurFile[0]);
  couleur.resize(couleur.width/2, couleur.height/2);
  light = loadImage("light.png");
  light.resize(height, height);


  arg1 = new Argument(0);
  arg2 = new Argument(1);
  arg3 = new Argument(2);
  arg4 = new Argument(3);

  xCout = width/2;
  yCout = height/2;
  xCouleur = width/2;
  yCouleur = 40 + height/2;
}


public void draw() {
  background(0);
  imageMode (CENTER);
  tint(colorized, colorized +180, 255);

  lighter();
  cout();


  arg1.update(ii%4);
  arg2.update(ii%4);
  arg3.update(ii%4);
  arg4.update(ii%4);
  couleur();
  buttons();
  calculator();
}

public void keyPressed() {

  if (key == 's' || key == 'S') {
    saveFrame("/savedFrame/spell.png");
  }
}

public void mousePressed() {
  buttonsClick();
  mouseCout();
  mouseCouleur();
  arg1.mouse();
  arg2.mouse();
  arg3.mouse();
  arg4.mouse();
}

public void mouseReleased() {
  buttonsReleased();
}
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
    argument.resize(PApplet.parseInt(argument.width/2.2f), PApplet.parseInt (argument.height/2.2f));

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

  public void update(int currentCout) {

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

  public void calc() {

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

  public void mouse() {
    calc();
    if (abs (mouseX - xArgument) < argument.width/2 && abs (mouseY- yArgument) < argument.height/2) {
      i++;
      argument = loadImage(argumentFile[i%4]);
      argument.resize(PApplet.parseInt(argument.width/2.2f), PApplet.parseInt (argument.height/2.2f));
    }
  }
}

public void lighter() {

  push();

  switch (iii%7) {
  case 0 :
    tint(255, 50, 50, 100);
    break;
  case 1 :
    tint(50, 255, 50, 100);
    break;
  case 2 :
    tint(50, 50, 255, 100);
    break;
  case 3 :
    tint(255, 255, 255, 100);
    break;
  case 4 :
    tint(255, 255, 50, 100);
    break;
  case 5 :
    tint(0, 255, 255, 100);
    break;
  case 6 :
    tint(255, 50, 255, 100);
    break;
  }

  // tint(colorized, colorized, 255, 80);
  image(light, width/2, 40 + height/2);
  pop();
}


public void cout() {
  switch(ii%4) {
  case 0: 
    xCout = width/2;
    yCout = height/2;
    break;
  case 1: 
    xCout = width/2;
    yCout = 38 +  height/2;
    break;
  case 2: 
    xCout = width/2;
    yCout = 15 +  height/2;
    break;
  case 3: 
    xCout = width/2;
    yCout = 38 +  height/2;
    break;
  }

  imageMode(CENTER);
  image(cout, xCout, yCout);
}

public void mouseCout() {

  if (abs (mouseX - xCout) < cout.width/4 && abs (mouseY-yCout) < cout.height/4 

    && abs (mouseX - xCout) > couleur.width/5 && abs (mouseY-yCout) >  couleur.height/5

    ) {
    ii++;
    cout = loadImage(coutFile[ii%4]);
    cout.resize(cout.width/2, cout.height/2);
  }
}

public void couleur() {

  imageMode(CENTER);
  image(couleur, xCouleur, yCouleur);
}

public void mouseCouleur() {

  if (abs (mouseX - xCouleur) < couleur.width/3 && abs (mouseY- yCouleur) < couleur.height/3) {
    iii++;
    couleur = loadImage(couleurFile[iii%7]);
    couleur.resize(couleur.width/2, couleur.height/2);
  }
}

public void buttons() {
  if (!HideHUD) {
    push();
    fill(255);
    textAlign(CENTER);
    text("Calculate", 110, 50);
    text("Save", 110, 110);
    text("Hide HUD", 880, 50);
    pop();

    push();
    noFill();
    strokeWeight(6);
    stroke(255);
    rectMode(CENTER);
    rect( 110, 40, 200, 50, 6);
    rect( 110, 100, 200, 50, 6);
    rect ( 880, 40, 200, 50, 6);
    pop();
  }
}

public void buttonsClick() {

  if (abs (mouseX - 110) < 200 && abs (mouseY- 40) < 50) {
    zoneTotal = 0;
    porteeTotal = 0;
    effetTotal = 1;
    tempsTotal = 0;

    calculate = true;
    thread("threadColor");
  }
  if (abs (mouseX - 110) < 200 && abs (mouseY- 100) < 50) {
    saveFrame("savedFrame/spell.png");
  }
  if (abs (mouseX - 880) < 200 && abs (mouseY- 50) < 50) {
    HideHUD = !HideHUD;
  }
}

public void buttonsReleased() {
  calculate = false;
}

public void threadColor() {
  colorized = 255;
  for (int c = 0; c < 255; c++) {
    colorized --;
    delay(4);
  }
  for (int c = 0; c < 255; c++) {
    colorized ++;
    delay(2);
  }
}

public void calculator() {

  switch(ii%4) {

  case 0 :
    coutTotal = 1;
    break;
  case 1 :
    coutTotal = 2;
    break;
  case 2 :
    coutTotal = 4;
    break;
  case 3 :
    coutTotal = 16;
    break;
  }
 if (!HideHUD) {
  text("coût : " + coutTotal, 20, 160);
  text("portée : " + porteeTotal + "m", 20, 200);
  text("effet : " + effetTotal + "d6", 20, 240);
  text("temps : " + tempsTotal + "d6", 20, 280);
  text("zone : " + zoneTotal +"m", 20, 320);
 }
}
  public void settings() {  size(1000, 720); }
  static public void main(String[] passedArgs) {
    String[] appletArgs = new String[] { "spellcalculator" };
    if (passedArgs != null) {
      PApplet.main(concat(appletArgs, passedArgs));
    } else {
      PApplet.main(appletArgs);
    }
  }
}
