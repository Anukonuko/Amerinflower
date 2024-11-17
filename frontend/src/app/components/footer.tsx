import styles from "src/app/styles/footer.module.css"
import Logo from "src/app/components/logo"

export default function Footer(){
  return (
    <footer className={styles.footerWrapper}>
      <Logo small />
    </footer>
  )
}