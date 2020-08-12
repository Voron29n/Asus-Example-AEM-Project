<template>
  <div class="footer-links_group">
    <div
      class="aai-footer-span"
      v-for="linksGroupItem in linksGroupData.linksGroup"
      :key="linksGroupItem.groupTitle"
    >
      <h4>{{ linksGroupItem.groupTitle }}</h4>
      <ul class="aai-fnav">
        <li
          v-for="linkItem in linksGroupItem.linksNames"
          :key="linkItem.descriptionLink"
        >
          <a :href="linkItem.linkTo" :target="linkItem.linkUrlTarget">{{
            linkItem.descriptionLink
          }}</a>
        </li>
      </ul>
    </div>
  </div>
</template>

<script>
export default {
  props: {
    linksGroupData: Object,
  },
};
</script>

<style lang="scss">
@import "./links_group_default";
@import "./links_group_media";
</style>
