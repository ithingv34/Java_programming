const { getFilesOf } = require('./util.js');

module.exports = {
  base: '/Reading/',
  assetsPublicPath: '/',
  title: " Certified Kubernetes Administrator (CKA)",
  plugins: ['@vuepress/last-updated'],
  themeConfig: {
    nav: [
      { text: 'Home', link: '/' }
    ],
    sidebar: [
      ['/', 'Certified Kubernetes Administrator (CKA)'],
      {
        title: 'CKA',
        path: '/docs/CKA/',
        children: getFilesOf('docs/CKA'),
      },
      {
        title: 'ClusterArchitecture',
        path: '/docs/ClusterArchitecture/',
        children: getFilesOf('docs/ClusterArchitecture'),
      },
      {
        title: 'Workloads Scheduling',
        path: '/docs/Workloads Scheduling/',
        children: getFilesOf('docs/Workloads Scheduling'),
      },
      {
        title: 'Services Networking',
        path: '/docs/Services Networking/',
        children: getFilesOf('docs/Services Networking'),
      },
      {
        title: 'Storage',
        path: '/docs/Storage/',
        children: getFilesOf('docs/Storage'),
      },
      {
        title: 'TroubleShooting',
        path: '/docs/TroubleShooting/',
        children: getFilesOf('docs/TroubleShooting'),
      }
    ],
    repo: 'ithingv34/vuepress_template',
    repoLabel: 'GitHub',
    editLinks: true,
    docsBranch: 'master',
    editLinkText: '잘못된 부분이 있다면 수정해주세요🙌!',
  },
};
