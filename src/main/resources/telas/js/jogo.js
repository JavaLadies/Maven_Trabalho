kaboom({
    global: true,
    fullscreen: true,
    scale: 2,
    clearColor: [0, 0, 0, 1]
})

loadSprite('bloco', 'jogo/pixel')
screen("jogo", () => {
            layer(["bg", "ui"], "obj")
            const map = [
                '                                  ',
                '                                  ',
                '                                  ',
                '                                  ',
                '                                  ',
                '                                  ',
                '                                  ',
                '              -------  ----       ',
                ' #                                ',
                'xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx',
            ]
            const levelcfg = {
                width: 20,
                heigth: 20,
                'x': [sprite('blooco'), solid()],
                '=': [sprite('bloco2.png'), solid()],
                '*': [sprite('robo'), solid()],
            }
            const jogoLevel =
        }