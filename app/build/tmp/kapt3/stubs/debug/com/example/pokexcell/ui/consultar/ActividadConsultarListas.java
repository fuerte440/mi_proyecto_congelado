package com.example.pokexcell.ui.consultar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0012H\u0002J\u0012\u0010\u0013\u001a\u00020\u00102\b\u0010\u0014\u001a\u0004\u0018\u00010\u0015H\u0014J\b\u0010\u0016\u001a\u00020\u0010H\u0014R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\nX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\fX\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\r\u001a\u00020\u000eX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0017"}, d2 = {"Lcom/example/pokexcell/ui/consultar/ActividadConsultarListas;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "cartaListaDAO", "Lcom/example/pokexcell/data/dao/CartaListaDAO;", "coleccionAdapter", "Lcom/example/pokexcell/ui/adapters/ListaAdapter;", "idUsuario", "", "listaDAO", "Lcom/example/pokexcell/data/dao/ListaDAO;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "usuarioDAO", "Lcom/example/pokexcell/data/dao/UsuarioDAO;", "enviarCorreoConLista", "", "lista", "Lcom/example/pokexcell/data/model/Lista;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onResume", "app_debug"})
public final class ActividadConsultarListas extends androidx.appcompat.app.AppCompatActivity {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.example.pokexcell.ui.adapters.ListaAdapter coleccionAdapter;
    private com.example.pokexcell.data.dao.ListaDAO listaDAO;
    private com.example.pokexcell.data.dao.CartaListaDAO cartaListaDAO;
    private com.example.pokexcell.data.dao.UsuarioDAO usuarioDAO;
    private int idUsuario = -1;
    
    public ActividadConsultarListas() {
        super();
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onResume() {
    }
    
    private final void enviarCorreoConLista(com.example.pokexcell.data.model.Lista lista) {
    }
}