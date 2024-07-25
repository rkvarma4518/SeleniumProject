<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Virat Kohli Wikipedia Details</title>
</head>
<body>
    <h1>Virat Kohli Wikipedia Details</h1>
    <pre>
        <%= new com.example.scraper.WikipediaScraper().getViratKohliDetails() %>
    </pre>
</body>
</html>
