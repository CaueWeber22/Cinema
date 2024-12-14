$(document).ready(function () {
    // Adiciona um ouvinte de evento para mudança no estado do checkbox
    $('#toggle-checkbox').change(function () {
        if ($(this).is(':checked')) {
            enviarCookie('dark');
        } else {
            enviarCookie('white');
        }
    });

    // Função para enviar o tema selecionado para o backend
    function enviarCookie(tema) {
        $.ajax({
            url: '/MudancaTema',
            method: 'POST',
            contentType: 'application/json',
            data: JSON.stringify(tema),
            success: function (response) {
                console.log('Success:', response);
            },
            error: function (error) {
                console.error('Error:', error);
            }
        });
   }
})
