<template>
  <div>
    <section class="cmc-hot-prod">
      <v-title :title-data="titleData"></v-title>
      <div class="commercial-inner">
        <v-productGroups
          :product-groups-data="productGroupsData"
        ></v-productGroups>
      </div>
    </section>
  </div>
</template>

<script>
import TitleData from "./v-components/title/Title";
import ProductGroupsData from "./v-components/product-groups/ProductGroups";

export default {
  components: {
    "v-title": TitleData,
    "v-productGroups": ProductGroupsData,
  },
  props: {
    groupsTitle: {
      type: String,
      required: false,
    },
    hotProductsInfo: {
      type: String,
      required: false,
    },
  },
  computed: {
    titleData() {
      return {
        groupsTitle: this.$props.groupsTitle,
      };
    },
    productGroupsData() {
      return {
        hotProductsInfo: JSON.parse(this.$props.hotProductsInfo),
      };
    },
  },
};
</script>

<style lang="scss">
@import "./v-style/hot_product_groups_default";
@import "./v-style/hot_product_groups_media";
</style>
