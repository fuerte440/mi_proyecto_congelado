package com.example.pokexcell.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\n\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJ\u0010\u0010\r\u001a\u00020\b2\u0006\u0010\u000e\u001a\u00020\nH\u0007J\u0018\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\f2\u0006\u0010\u0012\u001a\u00020\fJ\u0010\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\t\u001a\u00020\nJ\u000e\u0010\u0014\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nJ\u000e\u0010\u0015\u001a\u00020\f2\u0006\u0010\u000e\u001a\u00020\nJ\u0010\u0010\u0016\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0017\u001a\u00020\fJ\u000e\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u0010R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/example/pokexcell/data/dao/UsuarioDAO;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dbHelper", "Lcom/example/pokexcell/data/db/PokexcelDBHelper;", "actualizarEmail", "", "idUsuario", "", "nuevoEmail", "", "eliminarUsuario", "id", "iniciarSesion", "Lcom/example/pokexcell/data/model/Usuario;", "nombreUsuario", "contrasena", "obtenerContrasena", "obtenerEmail", "obtenerNombreUsuario", "obtenerUsuarioPorEmail", "email", "registrarUsuario2", "usuario", "app_debug"})
public final class UsuarioDAO {
    @org.jetbrains.annotations.NotNull()
    private final com.example.pokexcell.data.db.PokexcelDBHelper dbHelper = null;
    
    public UsuarioDAO(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    public final boolean registrarUsuario2(@org.jetbrains.annotations.NotNull()
    com.example.pokexcell.data.model.Usuario usuario) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.pokexcell.data.model.Usuario iniciarSesion(@org.jetbrains.annotations.NotNull()
    java.lang.String nombreUsuario, @org.jetbrains.annotations.NotNull()
    java.lang.String contrasena) {
        return null;
    }
    
    public final boolean actualizarEmail(int idUsuario, @org.jetbrains.annotations.NotNull()
    java.lang.String nuevoEmail) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.example.pokexcell.data.model.Usuario obtenerUsuarioPorEmail(@org.jetbrains.annotations.NotNull()
    java.lang.String email) {
        return null;
    }
    
    @android.annotation.SuppressLint(value = {"UseKtx"})
    public final boolean eliminarUsuario(int id) {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String obtenerContrasena(int idUsuario) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String obtenerNombreUsuario(int id) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String obtenerEmail(int id) {
        return null;
    }
}