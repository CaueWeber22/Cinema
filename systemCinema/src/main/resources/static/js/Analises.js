$(document).ready(function () {

    $(".btnExcluir").click(function (event) {
        event.preventDefault();

        var form = $(this).closest("form"); // Obter form mais próximo do elemento

        Swal.fire({
            title: 'Tem certeza que deseja excluir esta análise?',
            text: "Você não poderá reverter isso!",
            icon: 'warning',
            showCancelButton: true,
            confirmButtonColor: '#3085d6',
            cancelButtonColor: '#d33',
            cancelButtonText: 'Cancelar',
            confirmButtonText: 'Confirmar'
        }).then((result) => {
            if (result.isConfirmed) {
                form.submit();
            }
        });
    });
    
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
        $('.text').addClass('dark-p').removeClass('white-p');       
    }
    //Deixar site com tema white
    function temaWhite() {
        $('body').addClass("white-body").removeClass("dark-body");
        $('.text').addClass("white-p").removeClass("dark-p");            
    }
})