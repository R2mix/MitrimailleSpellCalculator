
void lighter() {

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


void cout() {
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

void mouseCout() {

  if (abs (mouseX - xCout) < cout.width/4 && abs (mouseY-yCout) < cout.height/4 

    && abs (mouseX - xCout) > couleur.width/5 && abs (mouseY-yCout) >  couleur.height/5

    ) {
    ii++;
    cout = loadImage(coutFile[ii%4]);
    cout.resize(cout.width/2, cout.height/2);
  }
}

void couleur() {

  imageMode(CENTER);
  image(couleur, xCouleur, yCouleur);
}

void mouseCouleur() {

  if (abs (mouseX - xCouleur) < couleur.width/3 && abs (mouseY- yCouleur) < couleur.height/3) {
    iii++;
    couleur = loadImage(couleurFile[iii%7]);
    couleur.resize(couleur.width/2, couleur.height/2);
  }
}

void buttons() {
  push();
  fill(255);
  textAlign(CENTER);
  text("Calculate", 110, 50);
  text("Save", 110, 110);
  pop();

  push();
  noFill();
  strokeWeight(6);
  stroke(255);
  rectMode(CENTER);
  rect( 110, 40, 200, 50, 6);
  rect( 110, 100, 200, 50, 6);
  pop();
}

void buttonsClick() {

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
}

void buttonsReleased() {
  calculate = false;
}

void threadColor() {
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

void calculator() {

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

  text("coût : " + coutTotal, 20, 160);
  text("portée : " + porteeTotal + "m", 20, 200);
  text("effet : " + effetTotal + "d6", 20, 240);
  text("temps : " + tempsTotal + "d6", 20, 280);
  text("zone : " + zoneTotal +"m", 20, 320);
}
