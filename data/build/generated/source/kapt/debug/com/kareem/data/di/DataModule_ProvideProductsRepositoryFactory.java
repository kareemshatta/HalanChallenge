// Generated by Dagger (https://dagger.dev).
package com.kareem.data.di;

import com.kareem.domain.repositories.products.ProductsRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;

@DaggerGenerated
@SuppressWarnings({
    "unchecked",
    "rawtypes"
})
public final class DataModule_ProvideProductsRepositoryFactory implements Factory<ProductsRepository> {
  @Override
  public ProductsRepository get() {
    return provideProductsRepository();
  }

  public static DataModule_ProvideProductsRepositoryFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static ProductsRepository provideProductsRepository() {
    return Preconditions.checkNotNullFromProvides(DataModule.INSTANCE.provideProductsRepository());
  }

  private static final class InstanceHolder {
    private static final DataModule_ProvideProductsRepositoryFactory INSTANCE = new DataModule_ProvideProductsRepositoryFactory();
  }
}