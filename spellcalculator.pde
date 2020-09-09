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


void setup() {
  size(1000, 720); 
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


void draw() {
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

void keyPressed() {

  if (key == 's' || key == 'S') {
    saveFrame("/savedFrame/spell.png");
  }
}

void mousePressed() {
  buttonsClick();
  mouseCout();
  mouseCouleur();
  arg1.mouse();
  arg2.mouse();
  arg3.mouse();
  arg4.mouse();
}

void mouseReleased() {
  buttonsReleased();
}
