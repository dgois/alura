$(".delete-score-button").click(deleteRow);
$("#toggle-scoreboard").click(toggleScoreboard);
$("#sync").click(syncScoreboard);

function updateUserScoreboard() {
    var numTypedWords = $('#info-num-typed-words').text(),
        user = 'Denis',
        scoreboard = $(".scoreboard"),
        tableScoreboard = $(".scoreboard").find('tbody'),
        resultRow = newRow(user, numTypedWords);

    tableScoreboard.prepend(resultRow);
    scoreboard.slideDown(500);
    scrollScoreboard(scoreboard);
}

function scrollScoreboard(scoreboard) {
    var topPosition = scoreboard.offset().top;

    $("html").animate({
        scrollTop: `${topPosition}px`
    }, 1000);
}

function newRow(user, numWords) {
    var row = $('<tr>'),
        userColumnn = $('<td>').text(user),
        wordsColumn = $('<td>').text(numWords),
        linkColumn = $('<td>'),
        link = $('<a>').attr('href', '#').addClass('delete-score-button'),
        icon = $('<i>').addClass('small').addClass('material-icons').text('delete');

    link.append(icon);
    linkColumn.append(link);
    row.append(userColumnn);
    row.append(wordsColumn);
    row.append(linkColumn);
    $(row).find('.delete-score-button').click(deleteRow);
    return row;
}

function deleteRow(event) {
    event.preventDefault();
    console.log('test');

    var row = $(this).parent().parent();
    row.fadeOut(1000, function() {
        row.remove();
    });
}

function toggleScoreboard() {
    var scoreboard = $(".scoreboard");
    scoreboard.stop().slideToggle();
    scrollScoreboard(scoreboard);
}

function syncScoreboard() {

    var scoreboard = [],
        linhas = $('tbody>tr');

    linhas.each(function() {
        var user = $(this).find('td:nth-child(1)').text(),
            wordsNumber = $(this).find('td:nth-child(2)').text();

        var score = {
            usuario: user,
            pontos: wordsNumber
        }

        scoreboard.push(score);
    });

    var data = {
        placar: scoreboard
    }
    $.post('http://localhost:3000/placar', data, function() {
        console.log('It works');
    });
}

function updateScoreboardWithDatabaseData() {
    $.get('http://localhost:3000/placar', function(data) {
        $(data).each(function() {
            var row = newRow(this.usuario, this.pontos);
            $('tbody').append(row);
        });
    });
}