[#ftl]
<!DOCTYPE html>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Quote of the day</title>
    <meta content="width=device-width, initial-scale=1" name="viewport">
    <link href="https://fonts.gstatic.com" rel="preconnect">
    <link href="/css/style.css" rel="stylesheet">
    <link href="/images/favicon.png" rel="icon" type="image/png">
    [#--<style>
        .bold-first-word {
            font-weight: bold;
        }
    </style>--]
</head>
<body style="background-image: url(${picture});">
<blockquote>${quote}</blockquote>

[#--<blockquote><span class="bold-first-word">${quote?substring(0, quote?index_of(" "))}</span> ${quote?substring(quote?index_of(" ") + 1)}</blockquote>--]

</body>
</html>
