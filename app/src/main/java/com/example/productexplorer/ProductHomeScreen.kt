package com.example.productexplorer

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.Button
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.productexplorer.ui.theme.ProductExplorerTheme

@Composable
fun ProductHomeScreen(
    featuredProduct: ProductUi,
    onFeaturedProductClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Column(
        modifier = modifier.fillMaxSize().verticalScroll(rememberScrollState()).padding(16.dp)
    ) {
        HomeHeader()
        Spacer(Modifier.height(24.dp))
        SearchPreviewBar()
        Spacer(Modifier.height(24.dp))
        FeaturedProductSection(featuredProduct, onClick = onFeaturedProductClick)
    }
}

@Composable
fun HomeHeader(modifier: Modifier = Modifier) {
    Column(modifier) {
        Text("Product Explorer", style = MaterialTheme.typography.headlineMedium)
        Text("Découvrez les produits du moment", style = MaterialTheme.typography.bodyMedium)
    }
}

@Composable
fun SearchPreviewBar(modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.medium,
        tonalElevation = 2.dp
    ) {
        Text(
            "Rechercher un produit...",
            modifier = Modifier.padding(16.dp),
            style = MaterialTheme.typography.bodyMedium
        )
    }
}

@Composable
fun FeaturedProductSection(product: ProductUi, onClick: () -> Unit, modifier: Modifier = Modifier) {
    Surface(
        modifier = modifier.fillMaxWidth(),
        shape = MaterialTheme.shapes.large,
        tonalElevation = 4.dp
    ) {
        Column(Modifier.padding(16.dp)) {
            Text("Produit mis en avant", style = MaterialTheme.typography.titleMedium)
            Spacer(Modifier.height(12.dp))
            Text(product.title, style = MaterialTheme.typography.headlineSmall)
            Text(product.brand, style = MaterialTheme.typography.bodyMedium)
            Spacer(Modifier.height(12.dp))
            Button(onClick = onClick) {
                Text("Voir le produit")
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun ProductHomeScreenPreview() {
    ProductExplorerTheme {
        ProductHomeScreen(sampleProduct(), onFeaturedProductClick = {})
    }
}
