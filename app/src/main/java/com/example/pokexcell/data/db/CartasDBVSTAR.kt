package com.example.pokexcell.data.db

object CartasDBVSTAR {

    fun insertarCartasVStar(): List<String> {
        return listOf(
            // 001 - Absol
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Absol',
                'Pokémon VStar Universe 2023',
                '2023-12-02',
                '001/172',
                'Rare Holo',
                'https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SWSH12/SWSH12_EN_1.png',
                2,
                'nagimiso'
            );
            """.trimIndent(),

            // 002 - Altaria
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Altaria',
                'Pokémon VStar Universe 2023',
                '2023-12-02',
                '002/172',
                'Uncommon',
                'https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SWSH12/SWSH12_EN_2.png',
                2,
                'Yuu Nishida'
            );
            """.trimIndent(),

            // 003 - Articuno
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Articuno',
                'Pokémon VStar Universe 2023',
                '2023-12-02',
                '003/172',
                'Rare Holo',
                'https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SWSH12/SWSH12_EN_3.png',
                2,
                'aky CG Works'
            );
            """.trimIndent(),

            // 004 - Bidoof
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Bidoof',
                'Pokémon VStar Universe 2023',
                '2023-12-02',
                '004/172',
                'Common',
                'https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SWSH12/SWSH12_EN_4.png',
                2,
                'Mina Nakai'
            );
            """.trimIndent(),

            // 005 - Bibarel
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Bibarel',
                'Pokémon VStar Universe 2023',
                '2023-12-02',
                '005/172',
                'Rare Holo',
                'https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SWSH12/SWSH12_EN_5.png',
                2,
                'Jerky'
            );
            """.trimIndent(),

            // 006 - Boltund
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Boltund',
                'Pokémon VStar Universe 2023',
                '2023-12-02',
                '006/172',
                'Uncommon',
                'https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SWSH12/SWSH12_EN_6.png',
                2,
                'sowsow'
            );
            """.trimIndent(),

            // 007 - Bounsweet
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Bounsweet',
                'Pokémon VStar Universe 2023',
                '2023-12-02',
                '007/172',
                'Common',
                'https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SWSH12/SWSH12_EN_7.png',
                2,
                'Naoyo Kimura'
            );
            """.trimIndent(),

            // 008 - Calyrex
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Calyrex',
                'Pokémon VStar Universe 2023',
                '2023-12-02',
                '008/172',
                'Rare Holo',
                'https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SWSH12/SWSH12_EN_8.png',
                2,
                'aky CG Works'
            );
            """.trimIndent(),

            // 009 - Charizard V
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Charizard V',
                'Pokémon VStar Universe 2023',
                '2023-12-02',
                '009/172',
                'Ultra Rare',
                'https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SWSH12/SWSH12_EN_9.png',
                2,
                'aky CG Works'
            );
            """.trimIndent(),

            // 010 - Charizard VSTAR
            """
            INSERT INTO carta (
                nombre, coleccion, fecha_lanzamiento, numero_carta, rareza, url_imagen, id_coleccion, dibujante
            ) VALUES (
                'Charizard VSTAR',
                'Pokémon VStar Universe 2023',
                '2023-12-02',
                '010/172',
                'Ultra Rare',
                'https://assets.pokemon.com/static-assets/content-assets/cms2/img/cards/web/SWSH12/SWSH12_EN_10.png',
                2,
                'aky CG Works'
            );
            """.trimIndent()
        )
    }
}
