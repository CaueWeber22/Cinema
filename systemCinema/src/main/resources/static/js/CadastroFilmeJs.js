//VERIFICAR SE CAMPOS ESTÃO PREENCHIDOS CORRETAMENTE ANTES DE ABRIR MODAL
$(document).ready(function () {

    $('#abrirModal').click(function (event) {
        var titulo = $('#titulo').val();
        var sinopse = $('#sinopse').val();
        var dataLanc = $('#dataLanc').val();
        var generoSelecionado = $('#genero').find(':selected').val();
        //VERIFICAR SE CAMPOS ESTÃO PREENCHIDOS CORRETAMENTE 
        if (generoSelecionado === "") {
            alert("Selecione uma opção de gênero.");
            event.preventDefault();
        }
//VERIFICAR SE OS CAMPOS NÃO ESTÃO NULOS
        else if ((titulo === "") || (sinopse === "") || (dataLanc === "")) {
            alert("Preencha os campos");
            event.preventDefault();
        } else if ((dataLanc < 1850) || (dataLanc > 2030)) {
            alert("Escolha uma ano entre 1850 e 2030");
            event.preventDefault();
        } else {
            $('#confirmarModal').modal('show');
        }
    })

    $('#btnCadastrar').click(function () {
        alert("Cadastro feito com sucesso");
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



