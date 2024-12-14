$(document).ready(function(){
     $('input[type=radio]').click(function(){
        if($(this).attr("value") === "opAlterar"){
            $("#div-alterar").removeClass("esconder");
            $("#div-excluir").addClass("esconder");
        }
        else if($(this).attr("value") === "opExcluir"){
            $("#div-alterar").addClass("esconder");
            $("#div-excluir").removeClass("esconder");
        }
    });
    
    //ADICIONAR SELECT2 PARA TORNAR POSSÍVEL PESQUISAS NO SELECT
    $('#idFilme').select2();
    $('#idFilmeExcluir').select2();  
    
    //ABRIR MODAL DE CONFIRMAÇÃO E FAZER VALIDAÇÃO
    $('#abrirModalAlteracao').click(function(event){
        var titulo = $('#titulo').val();
        var sinopse = $('#sinopse').val();
        var dataLanc = $('#dataLanc').val();
        var generoSelecionado = $('#genero').find(':selected').val();
        var idFilmeSelecionado = $('#idFilme').val();

        //VERIFICAR SE CAMPOS ESTÃO PREENCHIDOS CORRETAMENTE E ABRIR MODAL 
        // DE CONFIRMAÇÃO PARA ALTERAÇÃO
        if (idFilmeSelecionado === "0") {
            alert("Selecione um filme");
            event.preventDefault()
        } else if (generoSelecionado === "") {
            alert("Selecione uma opção de gênero.");
            event.preventDefault();
        } else if ((titulo === "") || (sinopse === "") || (dataLanc === "")) {
            alert("Preencha os campos");
            event.preventDefault();
        } else if ((dataLanc<1850) ||(dataLanc>2030) ) {
            alert("Escolha uma ano entre 1850 e 2030");
            event.preventDefault();
        } else{
        $('#alterarModal').modal('show');
        }
    })   
    //ALERT DE ALTERAÇÃO FEITA COM SUCESSO
    $("#btnAlterar").click(function(){
        alert("Alteração feita com sucesso");
    })
    
    
      //ABRIR MODAL DE CONFIRMAÇÃO E FAZER VALIDAÇÃO
    $('#abrirModalExclusao').click(function(event){
        var idFilmeSelecionado = $('#idFilmeExcluir').val();
    //VERIFICAR SE CAMPOS ESTÃO PREENCHIDOS CORRETAMENTE E ABRIR MODAL 
        // DE CONFIRMAÇÃO PARA ALTERAÇÃO
        if (idFilmeSelecionado === "0") {
            alert("Selecione um filme");
            event.preventDefault();
        } else{
        $('#excluirModal').modal('show');
        }
    })
    
    //ALERT DE EXCLUSÃO FEITA COM SUCESSO
    $("#btnExcluir").click(function(){
        alert("Exclusão feita com sucesso");
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
        $('.text').addClass('dark-p').removeClass('white-p');       
    }
    //Deixar site com tema white
    function temaWhite() {
        $('body').addClass("white-body").removeClass("dark-body");
        $('.text').addClass("white-p").removeClass("dark-p");            
    }
    
})