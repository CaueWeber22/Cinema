//VERIFICAR SE CAMPSO ESTÃO PREENCHIDOS CORRETAMENTE
$(document).ready(function () {
    $('#abrirModal').click(function () {
        var idFilmeSelecionado = $('#idFilme').val();
        var txtAnalise = $('#txtAnalise').val();
        var nota = $('#nota').val();
        console.log(typeof txtAnalise)

        if (idFilmeSelecionado === "0") {
            alert("Selecione um filme");
            event.preventDefault()
        } else if ((txtAnalise === "") || (nota === "")) {
            alert("Preencha todos os campos");
            event.preventDefault();
        } else if (nota < 0 || nota > 10) {
            alert("Digite uma nota entre 0 e 10");
            event.preventDefault();
        } else {
            $('#confirmarModal').modal('show');
        }
    })

//ADICIONAR SELECT2 PARA TORNAR POSSÍVEL PESQUISAS NO SELECT
    $("#idFilme").select2();


//ALERT APÓS CLICAR EM BOTÃO DE CADASTRO
    $('#btnCadastrar').click(function () {
        alert("Cadastro de análise feito com sucesso");
    })

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
        $('.text').addClass('dark-p').removeClass('white-p')
    }
    //Deixar site com tema white
    function temaWhite() {
        $('body').addClass("white-body").removeClass("dark-body");
        $('.text').addClass("white-p").removeClass("dark-p")
    }

})
        