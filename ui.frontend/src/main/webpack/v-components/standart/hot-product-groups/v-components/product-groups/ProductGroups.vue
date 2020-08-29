<template>
  <div class="promos-prod">
    <ul class="cmc-unit-group"> 
      <li
        v-for="productItem in productGroupsData.hotProductsInfo"
        :key="productItem.fileReference"
      >
        <img :src="productItem.fileReference" :alt="productItem.title" />
        <h3>{{productItem.title}}</h3>
        <p></p>
        <a :href="productItem.linkTo" :target="productItem.linkUrlTarget">{{productItem.descriptionLink}}</a>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    productGroupsData: Object,
  },
};
</script>

<style lang="scss">
@import "./product_groups_default";
@import "./product_groups_media";
</style>
