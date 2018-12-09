$('#shuffle').click(changePhrase);
$('#get-specific-phrase').click(getSpecificPhrase);

function changePhrase() {
    $('.spinner').toggle();
    $.get('http://localhost:3000/frases', updateRandomPhrase)
        .fail(showError)
        .always(function() {
            $('.spinner').toggle();
        });
}

function updateRandomPhrase(data) {
    var radomIndex = Math.floor(Math.random() * data.length);
    updatePhrase(data[radomIndex].texto, data[radomIndex].tempo);
}

function updateStopwatch(time) {
    initialTime = time;
    $('#time-to-end').text(time)
}

function updatePhraseSize() {
    var phrase = $('.phrase').text();
    var numWords = phrase.split(' ').length;
    var infoNumWord = $('#info-num-word');
    infoNumWord.text(numWords);
}

function getSpecificPhrase() {
    var phraseId = $('#phrase-id').val();

    var requestData = {
        id: phraseId
    }

    $('.spinner').toggle();
    $.get('http://localhost:3000/frases', requestData, updateSpecificPhrase)
        .fail(showError)
        .always(function() {
            $('.spinner').toggle();
        });

}

function updateSpecificPhrase(data) {
    updatePhrase(data.texto, data.tempo);
}

function updatePhrase(phrase, time) {
    $(".phrase").text(phrase);
    updateStopwatch(time);
    updatePhraseSize();
}

function showError() {
    $('.error').fadeIn(500);
    setTimeout(() => {
        $('.error').fadeOut(1500);
    }, 500);
}