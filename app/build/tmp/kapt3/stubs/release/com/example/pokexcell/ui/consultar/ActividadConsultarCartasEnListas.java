package com.example.pokexcell.ui.consultar;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\f\u001a\u00020\r2\b\u0010\u000e\u001a\u0004\u0018\u00010\u000fH\u0015R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082.\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082.\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082.\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0010"}, d2 = {"Lcom/example/pokexcell/ui/consultar/ActividadConsultarCartasEnListas;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "adapter", "Lcom/example/pokexcell/ui/adapters/CartaAdapter;", "cartaListaDAO", "Lcom/example/pokexcell/data/dao/CartaListaDAO;", "listaCartas", "", "Lcom/example/pokexcell/data/model/CartaConCantidad;", "recyclerView", "Landroidx/recyclerview/widget/RecyclerView;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "app_release"})
public final class ActividadConsultarCartasEnListas extends androidx.appcompat.app.AppCompatActivity {
    private androidx.recyclerview.widget.RecyclerView recyclerView;
    private com.example.pokexcell.ui.adapters.CartaAdapter adapter;
    private com.example.pokexcell.data.dao.CartaListaDAO cartaListaDAO;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.pokexcell.data.model.CartaConCantidad> listaCartas;
    
    public ActividadConsultarCartasEnListas() {
        super();
    }
    
    @java.lang.Override()
    @android.annotation.SuppressLint(value = {"NotifyDataSetChanged"})
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
}