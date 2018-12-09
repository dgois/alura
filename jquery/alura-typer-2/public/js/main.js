var initialTime = $('#time-to-end').text(),
    typedPhraseInput = $('#typed-phrase-input');

$(function() {
    updatePhraseSize();
    updateResults();
    initUpdateStopwatch();
    configureInputVerifier();
    $('#play-again').click(restartGame);
    updateScoreboardWithDatabaseData();
});

function updateResults(params) {
    typedPhraseInput.on('input', function() {
        var typedPhrase = typedPhraseInput.val();
        var numTypedWords = typedPhrase.split(/\S+/).length - 1;
        var numTypedChars = typedPhrase.length;

        $('#info-num-typed-words').text(numTypedWords);
        $('#info-num-typed-chars').text(numTypedChars);
    });
}

function initUpdateStopwatch() {
    typedPhraseInput.one('focus', function() {
        var remainingTime = $("#time-to-end").text();;
        $('#play-again').attr('disabled', true);

        createStopwatchWith(remainingTime);
    });
}

function configureInputVerifier() {
    typedPhraseInput.on('input', function() {
        let phrase = $('.phrase').text();
        var typed = typedPhraseInput.val();

        if (phrase.startsWith(typed)) {
            typedPhraseInput.addClass('correct-border');
            typedPhraseInput.removeClass('error-border');
        } else {
            typedPhraseInput.addClass('error-border');
            typedPhraseInput.removeClass('correct-border');
        }
        // var diff = phrase.substr(0, typedPhraseInput.val().length)
        // if (diff === typed) {
        //     typedPhraseInput.addClass('correct-border');
        //     typedPhraseInput.removeClass('error-border');
        // } else {
        //     typedPhraseInput.addClass('error-border');
        //     typedPhraseInput.removeClass('correct-border');
        // }

        // var isCorrect = RegExp(`^${typed}`).test(phrase);
        // typedPhraseInput.toggleClass('error-border', !isCorrect);
        // typedPhraseInput.toggleClass('correct-border', isCorrect);
    });
}

function createStopwatchWith(seconds) {
    let stopwatchId = setInterval(function() {
        seconds--;
        $("#time-to-end").text(seconds);

        if (seconds < 1) {
            clearInterval(stopwatchId);
            endGame();
        }

    }, 1000);
}

function endGame() {
    typedPhraseInput.attr('disabled', true);
    typedPhraseInput.addClass('disabled-input');
    $('#play-again').attr('disabled', false);
    updateUserScoreboard();
}

function restartGame(params) {
    typedPhraseInput.attr('disabled', false);
    typedPhraseInput.val('');
    $("#time-to-end").text(initialTime);

    $('#info-num-typed-words').text(0);
    $('#info-num-typed-chars').text(0);
    typedPhraseInput.removeClass('disabled-input');
    initUpdateStopwatch();
    typedPhraseInput.removeClass('error-border');
    typedPhraseInput.removeClass('correct-border');
}