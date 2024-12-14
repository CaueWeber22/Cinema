$(document).ready(function () {
    //Funções para tema da página
    //SETAR TEMA AO ABRIR
    // Ler cookie e definir tema inicial
    const tema = getCookie('tema');
    console.log(tema)
    if (tema === 'white') {
        temaWhite();
        $('#toggle-checkbox').prop('checked', false);
    } else {
        temaDark();
        $('#toggle-checkbox').prop('checked', true);
    }

    // Adiciona um ouvinte de evento para mudança no estado do checkbox
    $('#toggle-checkbox').change(function () {
        if ($(this).is(':checked')) {
            temaDark()
        } else {
            temaWhite();
        }
    });

    // Função para obter o valor de um cookie pelo nome
    function getCookie(name) {
        let matches = document.cookie.match(new RegExp(
                "(?:^|; )" + name.replace(/([\.$?*|{}\(\)\[\]\\\/\+^])/g, '\\$1') + "=([^;]*)"));
        return matches ? decodeURIComponent(matches[1]) : undefined;
    }

    //Deixar site com tema dark
    function temaDark() {
        $('body').addClass('dark-body').removeClass('white-body');
        $('.card-text').addClass('dark-p').removeClass('white-p');
        $('.text').addClass('dark-p').removeClass('white-p');
        $('.card').addClass('dark-card').removeClass('white-card');
        $('.card-header').addClass('dark-card-header').removeClass('white-card-header');
        $('.card-body').addClass('dark-card-body').removeClass('white-card-body');
        $('.card-footer').addClass('dark-card-footer').removeClass('white-card-footer');
    }
    //Deixar site com tema white
    function temaWhite() {
        $('body').addClass("white-body").removeClass("dark-body");
        $('.card-text').addClass("white-p").removeClass("dark-p")
        $('.text').addClass("white-p").removeClass("dark-p")
        $('.card').addClass('white-card').removeClass('dark-card')
        $('.card-header').addClass('white-card-header').removeClass('dark-card-header');
        $('.card-body').addClass('white-card-body').removeClass(' dark-card-body');
        $('.card-footer').addClass('white-card-footer ').removeClass('dark-card-footer');
        
    }
})
