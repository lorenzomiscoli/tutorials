int state = 0;

void setup() {
  pinMode(13,OUTPUT);
  pinMode(6,INPUT);
}

void loop() {
  state = digitalRead(6);
  
  if(state == HIGH){
    digitalWrite(13,HIGH);
  }
  
  else {
    digitalWrite(13,LOW);
  }
  
}
