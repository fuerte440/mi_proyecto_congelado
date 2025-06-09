package com.example.pokexcell.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0010\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\nH\u0002J\u0010\u0010\u000b\u001a\u0004\u0018\u00010\b2\u0006\u0010\f\u001a\u00020\rJ\u0018\u0010\u000e\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\rR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/example/pokexcell/data/dao/CartaDAO;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dbHelper", "Lcom/example/pokexcell/data/db/PokexcelDBHelper;", "cursorToCarta", "Lcom/example/pokexcell/data/model/Carta;", "cursor", "Landroid/database/Cursor;", "obtenerCartaPorId", "idCarta", "", "obtenerCartaPorNumero", "numeroCarta", "", "idColeccion", "app_debug"})
public final class CartaDAO {
    @org.jetbrains.annotations.NotNull()
    private final com.example.pokexcell.data.db.PokexcelDBHelper dbHelper = null;
    
    public CartaDAO(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.pokexcell.data.model.Carta obtenerCartaPorNumero(@org.jetbrains.annotations.NotNull()
    java.lang.String numeroCarta, int idColeccion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.pokexcell.data.model.Carta obtenerCartaPorId(int idCarta) {
        return null;
    }
    
    private final com.example.pokexcell.data.model.Carta cursorToCarta(android.database.Cursor cursor) {
        return null;
    }
}