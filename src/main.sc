require: slotfilling/slotFilling.sc
  module = sys.zb-common
theme: /

    state: Start
        q!: $regex</start>
        q!: (привет*/здравствуй*)
        random:
            a: Начнём.
            a: Привет.
        a: Помочь, хорошо?
        
        state: Yes
            q: * (да/давай*) *
            a: ок
                
        state: No
            q: * (нет/не) *
            a: плохо
        
        state: NoMatch
            event!: noMatch
            a: Я не понял.

    state: NoMatch
        event!: noMatch
        a: Я не понял. Вы сказали: {{$request.query}}
