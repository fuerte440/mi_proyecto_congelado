package com.example.pokexcell.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0014\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\u0006\u0010\u0010\u001a\u00020\fJ\u0014\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\u000e2\u0006\u0010\u000b\u001a\u00020\fJ\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\f0\u000e2\u0006\u0010\u0014\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\fR\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0015"}, d2 = {"Lcom/example/pokexcell/data/dao/CartaListaDAO;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "cartaDAO", "Lcom/example/pokexcell/data/dao/CartaDAO;", "dbHelper", "Lcom/example/pokexcell/data/db/PokexcelDBHelper;", "eliminarListaDeCartas", "", "idLista", "", "obtenerCartasPorColeccion", "", "Lcom/example/pokexcell/data/model/Carta;", "idColeccion", "obtenerCartasPorLista", "Lcom/example/pokexcell/data/model/CartaConCantidad;", "obtenerIdsCartasDeUsuarioPorColeccion", "idUsuario", "app_debug"})
public final class CartaListaDAO {
    @org.jetbrains.annotations.NotNull()
    private final com.example.pokexcell.data.db.PokexcelDBHelper dbHelper = null;
    @org.jetbrains.annotations.NotNull()
    private final com.example.pokexcell.data.dao.CartaDAO cartaDAO = null;
    
    public CartaListaDAO(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.pokexcell.data.model.CartaConCantidad> obtenerCartasPorLista(int idLista) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.pokexcell.data.model.Carta> obtenerCartasPorColeccion(int idColeccion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.Integer> obtenerIdsCartasDeUsuarioPorColeccion(int idUsuario, int idColeccion) {
        return null;
    }
    
    public final void eliminarListaDeCartas(int idLista) {
    }
}