package com.example.pokexcell.data.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000V\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\b\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0007\u001a\u00020\b2\u0006\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\fJF\u0010\r\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u000f\u001a\u00020\n2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\b\u0010\u0012\u001a\u0004\u0018\u00010\u00132\u0016\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0016j\u0002`\u0017\u0012\u0004\u0012\u00020\u000e0\u0015J<\u0010\u0018\u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0012\u001a\u00020\u00132\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u000e0\u00112\u0016\u0010\u0014\u001a\u0012\u0012\b\u0012\u00060\u0016j\u0002`\u0017\u0012\u0004\u0012\u00020\u000e0\u0015J\u000e\u0010\u0019\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\nJ\u0018\u0010\u001a\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001c\u001a\u00020\f2\u0006\u0010\u001d\u001a\u00020\fJ\u0010\u0010\u001e\u001a\u0004\u0018\u00010\u001b2\u0006\u0010\u001f\u001a\u00020\fJ\u000e\u0010 \u001a\u00020\u000e2\u0006\u0010\u0002\u001a\u00020\u0003J\u000e\u0010!\u001a\u00020\b2\u0006\u0010\"\u001a\u00020\u001bR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006#"}, d2 = {"Lcom/example/pokexcell/data/dao/UsuarioDAO;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dbHelper", "Lcom/example/pokexcell/data/db/PokexcelDBHelper;", "actualizarEmail", "", "idUsuario", "", "nuevoEmail", "", "eliminarUsuario", "", "id", "onSuccess", "Lkotlin/Function0;", "user", "Lcom/google/firebase/auth/FirebaseUser;", "onFailure", "Lkotlin/Function1;", "Ljava/lang/Exception;", "Lkotlin/Exception;", "eliminarUsuarioDeFirebase", "eliminarUsuarioDeSQLite", "iniciarSesion", "Lcom/example/pokexcell/data/model/Usuario;", "nombreUsuario", "contrasena", "obtenerUsuarioPorEmail", "email", "redirigirAlLogin", "registrarUsuario2", "usuario", "app_release"})
public final class UsuarioDAO {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
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
    
    public final void eliminarUsuario(@org.jetbrains.annotations.NotNull()
    android.content.Context context, int id, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.Nullable()
    com.google.firebase.auth.FirebaseUser user, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Exception, kotlin.Unit> onFailure) {
    }
    
    public final void eliminarUsuarioDeSQLite(int id) {
    }
    
    public final void eliminarUsuarioDeFirebase(@org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.google.firebase.auth.FirebaseUser user, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function0<kotlin.Unit> onSuccess, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super java.lang.Exception, kotlin.Unit> onFailure) {
    }
    
    public final void redirigirAlLogin(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
    }
}