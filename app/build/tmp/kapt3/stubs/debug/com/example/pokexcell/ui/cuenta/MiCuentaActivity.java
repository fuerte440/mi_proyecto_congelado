package com.example.pokexcell.ui.cuenta;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u000f\u001a\u00020\u00102\b\u0010\u0011\u001a\u0004\u0018\u00010\u0012H\u0014J\b\u0010\u0013\u001a\u00020\u0010H\u0002J\u0010\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0002J\b\u0010\u0018\u001a\u00020\u0010H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/example/pokexcell/ui/cuenta/MiCuentaActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "botonEliminarCuenta", "Landroid/widget/Button;", "botonGuardar", "botonVolver", "editarEmail", "Landroid/widget/EditText;", "idUsuario", "", "mGoogleSignInClient", "Lcom/google/android/gms/auth/api/signin/GoogleSignInClient;", "usuarioDAO", "Lcom/example/pokexcell/data/dao/UsuarioDAO;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "redirigirAlLogin", "validarEmail", "", "email", "", "volverAlMenu", "app_debug"})
public final class MiCuentaActivity extends androidx.appcompat.app.AppCompatActivity {
    private android.widget.EditText editarEmail;
    private android.widget.Button botonGuardar;
    private android.widget.Button botonEliminarCuenta;
    private android.widget.Button botonVolver;
    private com.example.pokexcell.data.dao.UsuarioDAO usuarioDAO;
    private int idUsuario = -1;
    private com.google.android.gms.auth.api.signin.GoogleSignInClient mGoogleSignInClient;
    
    public MiCuentaActivity() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final boolean validarEmail(java.lang.String email) {
        return false;
    }
    
    private final void volverAlMenu() {
    }
    
    private final void redirigirAlLogin() {
    }
}