from flask import Flask, render_template
from gpiozero import LED, TonalBuzzer

app = Flask(__name__)
led = LED(13)
buzz = TonalBuzzer(17)


@app.route('/')
def index():
    return render_template('index.html')


@app.before_request
def before():
    led.on()


@app.after_request
def after(response):
    led.off()
    return response


@app.route('/piezo/status', methods=['POST'])
def toggle():
    if buzz.is_active:
        buzz.stop()
    else:
        buzz.play(220)
    return {"status": buzz.is_active}


if __name__ == "__main__":
    app.run()
