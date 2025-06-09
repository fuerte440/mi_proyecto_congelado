package com.example.pokexcell.ui.adapters;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\b\n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001:\u0001\u0015B!\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u0012\f\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004\u00a2\u0006\u0002\u0010\bJ\"\u0010\t\u001a\u00020\n2\f\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00050\u00042\f\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004J\b\u0010\r\u001a\u00020\u0007H\u0016J\u0018\u0010\u000e\u001a\u00020\n2\u0006\u0010\u000f\u001a\u00020\u00022\u0006\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\u00022\u0006\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0007H\u0016R\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0006\u001a\b\u0012\u0004\u0012\u00020\u00070\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0016"}, d2 = {"Lcom/example/pokexcell/ui/adapters/CartaColeccionAdapter;", "Landroidx/recyclerview/widget/RecyclerView$Adapter;", "Lcom/example/pokexcell/ui/adapters/CartaColeccionAdapter$CartaViewHolder;", "cartas", "", "Lcom/example/pokexcell/data/model/Carta;", "idsCartasUsuario", "", "(Ljava/util/List;Ljava/util/List;)V", "actualizarDatos", "", "nuevasCartas", "nuevasIds", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "CartaViewHolder", "app_debug"})
public final class CartaColeccionAdapter extends androidx.recyclerview.widget.RecyclerView.Adapter<com.example.pokexcell.ui.adapters.CartaColeccionAdapter.CartaViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private java.util.List<com.example.pokexcell.data.model.Carta> cartas;
    @org.jetbrains.annotations.NotNull()
    private java.util.List<java.lang.Integer> idsCartasUsuario;
    
    public CartaColeccionAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.pokexcell.data.model.Carta> cartas, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> idsCartasUsuario) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.example.pokexcell.ui.adapters.CartaColeccionAdapter.CartaViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.pokexcell.ui.adapters.CartaColeccionAdapter.CartaViewHolder holder, int position) {
    }
    
    public final void actualizarDatos(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.pokexcell.data.model.Carta> nuevasCartas, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.Integer> nuevasIds) {
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\t\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000b\u00a8\u0006\f"}, d2 = {"Lcom/example/pokexcell/ui/adapters/CartaColeccionAdapter$CartaViewHolder;", "Landroidx/recyclerview/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Landroid/view/View;)V", "imagenCarta", "Landroid/widget/ImageView;", "getImagenCarta", "()Landroid/widget/ImageView;", "overlayRojo", "getOverlayRojo", "()Landroid/view/View;", "app_debug"})
    public static final class CartaViewHolder extends androidx.recyclerview.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.NotNull()
        private final android.widget.ImageView imagenCarta = null;
        @org.jetbrains.annotations.NotNull()
        private final android.view.View overlayRojo = null;
        
        public CartaViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.widget.ImageView getImagenCarta() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final android.view.View getOverlayRojo() {
            return null;
        }
    }
}