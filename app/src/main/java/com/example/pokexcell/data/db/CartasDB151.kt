package com.example.pokexcell.data.db

object CartasDB151 {

    fun insertarCartas151(): List<String> {
        return listOf(
            // 001 - Bulbasaur
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Bulbasaur',
                'Pokémon Card 151 2023',
                '2023-06-16',
                '001/165',
                'Common',
                'https://assets.pokemon.com/static-assets/content-assets/cms2-es-es/img/cards/web/SV3PT5/SV3PT5_ES_1.png',
                1,
                'kantaro'
            );
            """.trimIndent(),

            // 002 - Ivysaur
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Ivysaur',
                'Pokémon Card 151 2023',
                '2023-06-16',
                '002/165',
                'Uncommon',
                'https://assets.pokemon.com/static-assets/content-assets/cms2-es-es/img/cards/web/SV3PT5/SV3PT5_ES_2.png',
                1,
                'Souichirou Gunjima'
            );
            """.trimIndent(),

            // 003 - Venusaur
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Venusaur',
                'Pokémon Card 151 2023',
                '2023-06-16',
                '003/165',
                'Rare Holo',
                'https://assets.pokemon.com/static-assets/content-assets/cms2-es-es/img/cards/web/SV3PT5/SV3PT5_ES_3.png',
                1,
                'aky CG Works'
            );
            """.trimIndent(),

            // 004 - Charmander
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Charmander',
                'Pokémon Card 151 2023',
                '2023-06-16',
                '004/165',
                'Common',
                'https://assets.pokemon.com/static-assets/content-assets/cms2-es-es/img/cards/web/SV3PT5/SV3PT5_ES_4.png',
                1,
                'Mina Nakai'
            );
            """.trimIndent(),

            // 005 - Charmeleon
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Charmeleon',
                'Pokémon Card 151 2023',
                '2023-06-16',
                '005/165',
                'Uncommon',
                'https://assets.pokemon.com/static-assets/content-assets/cms2-es-es/img/cards/web/SV3PT5/SV3PT5_ES_5.png',
                1,
                'Yuu Nishida'
            );
            """.trimIndent(),

            // 006 - Charizard
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Charizard',
                'Pokémon Card 151 2023',
                '2023-06-16',
                '006/165',
                'Rare Holo',
                'https://assets.pokemon.com/static-assets/content-assets/cms2-es-es/img/cards/web/SV3PT5/SV3PT5_ES_6.png',
                1,
                'aky CG Works'
            );
            """.trimIndent(),

            // 007 - Squirtle
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Squirtle',
                'Pokémon Card 151 2023',
                '2023-06-16',
                '007/165',
                'Common',
                'https://assets.pokemon.com/static-assets/content-assets/cms2-es-es/img/cards/web/SV3PT5/SV3PT5_ES_7.png',
                1,
                'Yuka Morii'
            );
            """.trimIndent(),

            // 008 - Wartortle
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Wartortle',
                'Pokémon Card 151 2023',
                '2023-06-16',
                '008/165',
                'Uncommon',
                'https://assets.pokemon.com/static-assets/content-assets/cms2-es-es/img/cards/web/SV3PT5/SV3PT5_ES_8.png',
                1,
                'Jerky'
            );
            """.trimIndent(),

            // 009 - Blastoise
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Blastoise',
                'Pokémon Card 151 2023',
                '2023-06-16',
                '009/165',
                'Rare Holo',
                'https://assets.pokemon.com/static-assets/content-assets/cms2-es-es/img/cards/web/SV3PT5/SV3PT5_ES_9.png',
                1,
                'aky CG Works'
            );
            """.trimIndent(),

            // 010 - Caterpie
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Caterpie',
                'Pokémon Card 151 2023',
                '2023-06-16',
                '010/165',
                'Common',
                'https://assets.pokemon.com/static-assets/content-assets/cms2-es-es/img/cards/web/SV3PT5/SV3PT5_ES_10.png',
                1,
                'sowsow'
            );
            """.trimIndent()
        )
    }
}

