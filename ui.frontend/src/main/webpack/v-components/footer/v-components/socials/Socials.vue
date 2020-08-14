<template>
  <div class="footer-socials aai-footer-span"
  @click="$emit('open-social-group', 0, true, $event)">
    <h4>{{ socialsData.socialsTitle }}</h4>
    <ul class="aai-fnav">
      <li class="aai-social-media">
        <span
        v-for="socialsItem in socialsData.socials"
        :key="socialsItem.fileReference"
      >
        <a :href="socialsItem.linkTo" :target="socialsItem.linkUrlTarget">
          <img :src="socialsItem.fileReference" :alt="socialsItem.title" />
        </a>
        </span>
      </li>
    </ul>
  </div>
</template>

<script>
export default {
  props: {
    socialsData: Object,
    default: () => ({}),
  },
};
</script>

<style lang="scss">
@import "./socials_default";
@import "./socials_media";
</style>
